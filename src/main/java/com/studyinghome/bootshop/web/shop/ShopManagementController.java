package com.studyinghome.bootshop.web.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studyinghome.bootshop.dto.ShopExecution;
import com.studyinghome.bootshop.entity.*;
import com.studyinghome.bootshop.enums.ProductCategoryStateEnum;
import com.studyinghome.bootshop.enums.ShopStateEnum;
import com.studyinghome.bootshop.service.AreaService;
import com.studyinghome.bootshop.service.LocalAuthService;
import com.studyinghome.bootshop.service.ShopCategoryService;
import com.studyinghome.bootshop.service.ShopService;
import com.studyinghome.bootshop.util.CodeUtil;
import com.studyinghome.bootshop.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private LocalAuthService localAuthService;

    @GetMapping("/list")
    private Map<String, Object> list(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
        long employeeId = user.getUserId();
        if (hasAccountBind(request, employeeId)) {
            modelMap.put("hasAccountBind", true);
        } else {
            modelMap.put("hasAccountBind", false);
        }
        try {
            ShopExecution shopExecution = shopService.getByEmployeeId(employeeId);
            List<Shop> list = shopExecution.getShopList();
            modelMap.put("shopList", list);
            modelMap.put("user", user);
            modelMap.put("success", true);
            // 列出店铺成功之后，将店铺放入session中作为权限验证依据，即该帐号只能操作它自己的店铺
            request.getSession().setAttribute("shopList", list);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }

    @GetMapping("/getshopbyid")
    private Map<String, Object> getShopById(@RequestParam Long shopId,
                                            HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        if (shopId != null && shopId > -1) {
            Shop shop = shopService.getByShopId(shopId);
            shop.getShopCategory().setShopCategoryName(
                    shopCategoryService.getShopCategoryById(
                            shop.getShopCategory().getShopCategoryId()).getShopCategoryName());
            shop.getParentCategory().setShopCategoryName(
                    shopCategoryService.getShopCategoryById(
                            shop.getParentCategory().getShopCategoryId()).getShopCategoryName());
            modelMap.put("shop", shop);
            request.getSession().setAttribute("currentShop", "shop");
            List<Area> areaList = new ArrayList<>();
            try {
                areaList = areaService.getAreaList();
            } catch (IOException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
            }
            modelMap.put("areaList", areaList);
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty shopId");
        }
        return modelMap;
    }

    @GetMapping("/getshopinitinfo")
    private Map<String, Object> getShopInitInfo() {
        Map<String, Object> modelMap = new HashMap<>();
        List<ShopCategory> shopCategoryList = new ArrayList<>();
        List<Area> areaList = new ArrayList<>();
        try {
            shopCategoryList = shopCategoryService.getAllSecondLevelShopCategory();
            areaList = areaService.getAreaList();
        } catch (IOException e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        modelMap.put("shopCategoryList", shopCategoryList);
        modelMap.put("areaList", areaList);
        modelMap.put("success", true);
        return modelMap;
    }

    @PostMapping("/modifyshop")
    private Map<String, Object> modifyShop(HttpServletRequest request) {
        boolean statusChange = HttpServletRequestUtil.getBoolean(request, "statusChange");
        Map<String, Object> modelMap = new HashMap<>();
        if (!statusChange && !CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "输入了错误的验证码");
            return modelMap;
        }
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartRequest.getFile("shopImg");
        }
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        shop.setShopId(currentShop.getShopId());
        if (shop != null && shop.getShopId() != null) {
            filterAttribute(shop);
            try {
                ShopExecution se = shopService.modifyShop(shop, shopImg);
                if (se.getState() == ProductCategoryStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", se.getStateInfo());
                }
            } catch (RuntimeException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }

        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入店铺信息");
        }
        return modelMap;
    }

    @PostMapping("/registershop")
    private Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "输入了错误的验证码");
            return modelMap;
        }
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        MultipartHttpServletRequest multipartRequest = null;
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            multipartRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartRequest.getFile("shopImg");
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "上传图片不能为空");
            return modelMap;
        }
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        if (shop != null && shopImg != null) {
            try {
                PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
                shop.setOwnerId(user.getUserId());
                ShopExecution se = shopService.addShop(shop, shopImg);
                if (se.getState() == ShopStateEnum.CHECK.getState()) {
                    modelMap.put("success", true);
                    // 若shop创建成功，则加入session中，作为权限使用
                    @SuppressWarnings("unchecked")
                    List<Shop> shopList = (List<Shop>) request.getSession().getAttribute("shopList");
                    if (shopList != null && shopList.size() > 0) {
                        shopList.add(se.getShop());
                        request.getSession().setAttribute("shopList", shopList);
                    } else {
                        shopList = new ArrayList<Shop>();
                        shopList.add(se.getShop());
                        request.getSession().setAttribute("shopList", shopList);
                    }
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", se.getStateInfo());
                }
            } catch (RuntimeException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入店铺信息");
        }
        return modelMap;
    }

    private void filterAttribute(Shop shop) {

    }

    private boolean hasAccountBind(HttpServletRequest request, long userId) {
        if (request.getSession().getAttribute("bindAccount") == null) {
            LocalAuth localAuth = localAuthService.getLocalAuthByUserId(userId);
            if (localAuth != null && localAuth.getUserId() != null) {
                request.getSession().setAttribute("bindAccount", localAuth);
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
