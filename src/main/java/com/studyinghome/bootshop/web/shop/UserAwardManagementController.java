package com.studyinghome.bootshop.web.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studyinghome.bootshop.dto.ShopAuthMapExecution;
import com.studyinghome.bootshop.dto.UserAwardMapExecution;
import com.studyinghome.bootshop.entity.PersonInfo;
import com.studyinghome.bootshop.entity.Shop;
import com.studyinghome.bootshop.entity.ShopAuthMap;
import com.studyinghome.bootshop.entity.UserAwardMap;
import com.studyinghome.bootshop.enums.UserAwardMapStateEnum;
import com.studyinghome.bootshop.service.ShopAuthMapService;
import com.studyinghome.bootshop.service.UserAwardMapService;
import com.studyinghome.bootshop.util.HttpServletRequestUtil;
import com.studyinghome.bootshop.util.weixin.message.req.WechatInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class UserAwardManagementController {
    @Autowired
    private UserAwardMapService userAwardMapService;
    @Autowired
    private ShopAuthMapService shopAuthMapService;

    @GetMapping("/listuserawardmapsbyshop")
    private Map<String, Object> listUserAwardMapsByShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        if ((pageIndex > -1) && (pageSize > -1) && (currentShop != null)
                && (currentShop.getShopId() != null)) {
            UserAwardMap userAwardMap = new UserAwardMap();
            userAwardMap.setShopId(currentShop.getShopId());
            String awardName = HttpServletRequestUtil.getString(request, "awardName");
            if (awardName != null) {
                userAwardMap.setAwardName(awardName);
            }
            UserAwardMapExecution ue = userAwardMapService.listUserAwardMap(userAwardMap, pageIndex, pageSize);
            modelMap.put("userAwardMapList", ue.getUserAwardMapList());
            modelMap.put("count", ue.getCount());
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
        }
        return modelMap;
    }

    @PostMapping("/exchangeaward")
    private Map<String, Object> exchangeAward(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
        String qrCodeinfo = HttpServletRequestUtil.getString(request, "state");
        ObjectMapper mapper = new ObjectMapper();
        WechatInfo wechatInfo = null;
        try {
            wechatInfo = mapper.readValue(qrCodeinfo, WechatInfo.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        if (!checkQRCodeInfo(wechatInfo)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "二维码信息非法！");
            return modelMap;
        }
        Long userAwardId = wechatInfo.getUserAwardId();
        Long customerId = wechatInfo.getCustomerId();
        UserAwardMap userAwardMap = compactUserAwardMap4Exchange(customerId, userAwardId);
        if (userAwardMap != null) {
            try {
                if (!checkShopAuth(user.getUserId(), userAwardMap)) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", "无操作权限");
                    return modelMap;
                }
                UserAwardMapExecution se = userAwardMapService.modifyUserAwardMap(userAwardMap);
                if (se.getState() == UserAwardMapStateEnum.SUCCESS.getState()) {
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
            modelMap.put("errMsg", "请输入领取信息");
        }
        return modelMap;
    }

    private boolean checkQRCodeInfo(WechatInfo wechatInfo) {
        if (wechatInfo != null && wechatInfo.getUserAwardId() != null
                && wechatInfo.getCustomerId() != null
                && wechatInfo.getCreateTime() != null) {
            long nowTime = System.currentTimeMillis();
            if ((nowTime - wechatInfo.getCreateTime()) <= 5000) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private UserAwardMap compactUserAwardMap4Exchange(Long customerId, Long userAwardId) {
        UserAwardMap userAwardMap = null;
        if (customerId != null && userAwardId != null) {
            userAwardMap = userAwardMapService.getUserAwardMapById(userAwardId);
            userAwardMap.setUsedStatus(0);
            userAwardMap.setUserId(customerId);
        }
        return userAwardMap;
    }

    private boolean checkShopAuth(long userId, UserAwardMap userAwardMap) {
        ShopAuthMapExecution shopAuthMapExecution = shopAuthMapService
                .listShopAuthMapByShopId(userAwardMap.getShopId(), 1, 1000);
        for (ShopAuthMap shopAuthMap : shopAuthMapExecution.getShopAuthMapList()) {
            if (shopAuthMap.getEmployeeId() == userId) {
                return true;
            }
        }
        return false;
    }
}
