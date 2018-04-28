package com.studyinghome.bootshop.web.shop;

import com.studyinghome.bootshop.entity.Shop;
import com.studyinghome.bootshop.util.HttpServletRequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/shop", method = {RequestMethod.GET, RequestMethod.POST})
public class AdminController {

    @PostMapping("/te")
    public String test(){
        return "success";
    }

    @RequestMapping(value = "/test")
    public Map<String, Object> productcategory(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        String kaptchaExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        System.out.println(kaptchaExpected);
        modelMap.put("verifyCode", kaptchaExpected);
        return modelMap;
    }

    @RequestMapping(value = "/ownerlogin")
    public String ownerLogin(HttpServletRequest request) {
        return "shop/ownerlogin";
    }

    @GetMapping(value = "/register")
    private String register() {
        return "shop/register";
    }

    @GetMapping(value = "/changepsw")
    private String changePsw() {
        return "shop/changepsw";
    }

    @GetMapping(value = "/ownerbind")
    private String ownerBind() {
        return "shop/ownerbind";
    }

    @GetMapping(value = "/shoplist")
    private String myList() {
        return "shop/shoplist";
    }

    @GetMapping(value = "/shopmanage")
    private String shopManage(HttpServletRequest request) {
        long shopId = HttpServletRequestUtil.getLong(request, "shopId");
        if (shopId <= 0) {
            Object currentShopObj = request.getSession().getAttribute(
                    "currentShop");
            if (currentShopObj == null) {
                return "shop/shoplist";
            } else {
                return "shop/shopmanage";
            }
        } else {
            Shop currentShop = new Shop();
            currentShop.setShopId(shopId);
            request.getSession().setAttribute("currentShop", currentShop);
            return "shop/shopmanage";
        }
    }

    @GetMapping(value = "/shopedit")
    private String shopEdit() {
        return "shop/shopedit";
    }

    @GetMapping(value = "/productmanage")
    private String productManage() {
        return "shop/productmanage";
    }

    @GetMapping(value = "/productedit")
    private String productEdit() {
        return "shop/productedit";
    }

    @GetMapping(value = "/productcategorymanage")
    private String productCategoryManage() {
        return "shop/productcategorymanage";
    }

    @GetMapping(value = "/shopauthmanage")
    private String shopAuthManage() {
        return "shop/shopauthmanage";
    }

    @GetMapping(value = "/shopauthedit")
    private String shopAuthEdit() {
        return "shop/shopauthedit";
    }

    @GetMapping(value = "/productbuycheck")
    private String productBuyCheck() {
        return "shop/productbuycheck";
    }

    @GetMapping(value = "/awarddelivercheck")
    private String awardDeliverCheck() {
        return "shop/awarddelivercheck";
    }

    @GetMapping(value = "/usershopcheck")
    private String userShopCheck() {
        return "shop/usershopcheck";
    }

    @GetMapping(value = "/awardmanage")
    private String awardManage() {
        return "shop/awardmanage";
    }

    @GetMapping(value = "/awardedit")
    private String awardEdit() {
        return "shop/awardedit";
    }

    @GetMapping(value = "/customermanage")
    private String customerManage() {
        return "shop/customermanage";
    }
}
