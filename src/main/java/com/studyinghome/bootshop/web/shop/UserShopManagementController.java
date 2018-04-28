package com.studyinghome.bootshop.web.shop;

import com.studyinghome.bootshop.dto.UserShopMapExecution;
import com.studyinghome.bootshop.entity.Shop;
import com.studyinghome.bootshop.entity.UserShopMap;
import com.studyinghome.bootshop.service.UserShopMapService;
import com.studyinghome.bootshop.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class UserShopManagementController {
    @Autowired
    private UserShopMapService userShopMapService;

    @GetMapping("/listusershopmapsbyshop")
    private Map<String, Object> listUserShopMapsByShop(
            HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        if ((pageIndex > -1) && (pageSize > -1) && (currentShop != null)
                && (currentShop.getShopId() != null)) {
            UserShopMap userShopMapCondition = new UserShopMap();
            userShopMapCondition.setShopId(currentShop.getShopId());
            String userName = HttpServletRequestUtil.getString(request, "userName");
            if (userName != null) {
                userShopMapCondition.setUserName(userName);
            }
            UserShopMapExecution ue = userShopMapService.listUserShopMap(
                    userShopMapCondition, pageIndex, pageSize);
            modelMap.put("userShopMapList", ue.getUserShopMapList());
            modelMap.put("count", ue.getCount());
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
        }
        return modelMap;
    }

}
