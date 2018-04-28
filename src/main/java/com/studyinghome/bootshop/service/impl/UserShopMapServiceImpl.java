package com.studyinghome.bootshop.service.impl;

import com.studyinghome.bootshop.dao.UserShopMapDao;
import com.studyinghome.bootshop.dto.UserShopMapExecution;
import com.studyinghome.bootshop.entity.UserShopMap;
import com.studyinghome.bootshop.service.UserShopMapService;
import com.studyinghome.bootshop.util.PageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserShopMapServiceImpl implements UserShopMapService {
    @Autowired
    private UserShopMapDao userShopMapDao;

    @Override
    public UserShopMapExecution listUserShopMap(
            UserShopMap userShopMapCondition, int pageIndex, int pageSize) {
        if (userShopMapCondition != null && pageIndex != -1 && pageSize != -1) {
            int beginIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
            List<UserShopMap> userShopMapList = userShopMapDao
                    .queryUserShopMapList(userShopMapCondition, beginIndex, pageSize);
            int count = userShopMapDao.queryUserShopMapCount(userShopMapCondition);
            UserShopMapExecution ue = new UserShopMapExecution();
            ue.setUserShopMapList(userShopMapList);
            ue.setCount(count);
            return ue;
        } else {
            return null;
        }

    }
}
