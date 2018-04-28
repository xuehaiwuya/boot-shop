package com.studyinghome.bootshop.web.frontend;

import com.studyinghome.bootshop.entity.HeadLine;
import com.studyinghome.bootshop.entity.ShopCategory;
import com.studyinghome.bootshop.enums.HeadLineStateEnum;
import com.studyinghome.bootshop.enums.ShopCategoryStateEnum;
import com.studyinghome.bootshop.service.HeadLineService;
import com.studyinghome.bootshop.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/frontend")
public class MainPageController {
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private HeadLineService headLineService;

    @GetMapping(value = "/listmainpageinfo")
    private Map<String, Object> list1stShopCategory() {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            List<ShopCategory> shopCategoryList = shopCategoryService.getFirstLevelShopCategoryList();
            modelMap.put("shopCategoryList", shopCategoryList);
        } catch (Exception e) {
            e.printStackTrace();
            ShopCategoryStateEnum s = ShopCategoryStateEnum.INNER_ERROR;
            modelMap.put("success", false);
            modelMap.put("errMsg", s.getStateInfo());
            return modelMap;
        }
        try {
            HeadLine headLineCondition = new HeadLine();
            headLineCondition.setEnableStatus(1);
            List<HeadLine> headLineList = headLineService.getHeadLineList(headLineCondition);
            modelMap.put("headLineList", headLineList);
        } catch (Exception e) {
            e.printStackTrace();
            HeadLineStateEnum s = HeadLineStateEnum.INNER_ERROR;
            modelMap.put("success", false);
            modelMap.put("errMsg", s.getStateInfo());
            return modelMap;
        }
        modelMap.put("success", true);
        return modelMap;
    }

}
