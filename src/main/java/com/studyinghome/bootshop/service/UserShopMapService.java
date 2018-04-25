package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.UserShopMapExecution;
import com.studyinghome.bootshop.entity.UserShopMap;

public interface UserShopMapService {

    /**
     * 列出用户店铺列表
     *
     * @param userShopMapCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    UserShopMapExecution listUserShopMap(UserShopMap userShopMapCondition,
                                         int pageIndex, int pageSize);

}
