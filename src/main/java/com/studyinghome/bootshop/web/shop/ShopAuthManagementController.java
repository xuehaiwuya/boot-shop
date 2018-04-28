package com.studyinghome.bootshop.web.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studyinghome.bootshop.dto.ShopAuthMapExecution;
import com.studyinghome.bootshop.entity.PersonInfo;
import com.studyinghome.bootshop.entity.Shop;
import com.studyinghome.bootshop.entity.ShopAuthMap;
import com.studyinghome.bootshop.enums.ShopAuthMapStateEnum;
import com.studyinghome.bootshop.service.ShopAuthMapService;
import com.studyinghome.bootshop.util.CodeUtil;
import com.studyinghome.bootshop.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopAuthManagementController {
    @Autowired
    private ShopAuthMapService shopAuthMapService;

    @GetMapping(value = "/listshopauthmapsbyshop")
    private Map<String, Object> listShopAuthMapsByShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        if ((pageIndex > -1) && (pageSize > -1) && (currentShop != null)
                && (currentShop.getShopId() != null)) {
            ShopAuthMapExecution se = shopAuthMapService
                    .listShopAuthMapByShopId(currentShop.getShopId(), pageIndex, pageSize);
            modelMap.put("shopAuthMapList", se.getShopAuthMapList());
            modelMap.put("count", se.getCount());
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
        }
        return modelMap;
    }

    @GetMapping(value = "/getshopauthmapbyid")
    private Map<String, Object> getShopAuthMapById(@RequestParam Long shopAuthId) {
        Map<String, Object> modelMap = new HashMap<>();
        if (shopAuthId != null && shopAuthId > -1) {
            ShopAuthMap shopAuthMap = shopAuthMapService.getShopAuthMapById(shopAuthId);
            modelMap.put("shopAuthMap", shopAuthMap);
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty shopAuthId");
        }
        return modelMap;
    }

    @PostMapping(value = "/addshopauthmap")
    private Map<String, Object> addShopAuthMap(String shopAuthMapStr, HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        ShopAuthMap shopAuthMap = null;
        try {
            shopAuthMap = mapper.readValue(shopAuthMapStr, ShopAuthMap.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        if (shopAuthMap != null) {
            try {
                Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
                PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
                if (currentShop.getOwnerId() != user.getUserId()) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", "无操作权限");
                    return modelMap;
                }
                shopAuthMap.setShopId(currentShop.getShopId());
                shopAuthMap.setEmployeeId(user.getUserId());
                ShopAuthMapExecution se = shopAuthMapService.addShopAuthMap(shopAuthMap);
                if (se.getState() == ShopAuthMapStateEnum.SUCCESS.getState()) {
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
            modelMap.put("errMsg", "请输入授权信息");
        }
        return modelMap;
    }

    @PostMapping("/modifyshopauthmap")
    private Map<String, Object> modifyShopAuthMap(String shopAuthMapStr, HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "输入了错误的验证码");
            return modelMap;
        }
        ObjectMapper mapper = new ObjectMapper();
        ShopAuthMap shopAuthMap = null;
        try {
            shopAuthMap = mapper.readValue(shopAuthMapStr, ShopAuthMap.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        if (shopAuthMap != null && shopAuthMap.getShopAuthId() != null) {
            try {
                Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
                PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
                shopAuthMap.setShopId(currentShop.getShopId());
                shopAuthMap.setEmployeeId(user.getUserId());
                ShopAuthMapExecution se = shopAuthMapService.modifyShopAuthMap(shopAuthMap);
                if (se.getState() == ShopAuthMapStateEnum.SUCCESS.getState()) {
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
            modelMap.put("errMsg", "请输入要修改的授权信息");
        }
        return modelMap;
    }

    @GetMapping(value = "/removeshopauthmap")
    private Map<String, Object> removeShopAuthMap(Long shopAuthId) {
        Map<String, Object> modelMap = new HashMap<>();
        if (shopAuthId != null && shopAuthId > 0) {
            try {
                ShopAuthMapExecution se = shopAuthMapService.removeShopAuthMap(shopAuthId);
                if (se.getState() == ShopAuthMapStateEnum.SUCCESS.getState()) {
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
            modelMap.put("errMsg", "请至少选择一个授权进行删除");
        }
        return modelMap;
    }
}
