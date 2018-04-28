package com.studyinghome.bootshop.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frontend")
public class FrontendController {
    @GetMapping(value = "/mainpage")
    private String showMainPage() {
        return "frontend/mainpage";
    }

    @GetMapping(value = "/productdetail")
    private String showProductDetail() {
        return "frontend/productdetail";
    }

    @GetMapping(value = "/shopdetail")
    private String showShopDetail() {
        return "frontend/shopdetail";
    }

    @GetMapping(value = "/shoplist")
    private String showShopList() {
        return "frontend/shoplist";
    }

    @GetMapping(value = "/index")
    private String index() {
        return "frontend/index";
    }

    @GetMapping(value = "/mypoint")
    private String myPoint() {
        return "frontend/mypoint";
    }

    @GetMapping(value = "/myrecord")
    private String myRecord() {
        return "frontend/myrecord";
    }

    @GetMapping(value = "/pointrecord")
    private String pointRecord() {
        return "frontend/pointrecord";
    }

    @GetMapping(value = "/awarddetail")
    private String awardDetail() {
        return "frontend/awarddetail";
    }

    @GetMapping(value = "/customerbind")
    private String customerBind() {
        return "frontend/customerbind";
    }
}
