package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.UserShopMapExecution;
import com.studyinghome.bootshop.entity.UserShopMap;

public interface UserShopMapService {

	UserShopMapExecution listUserShopMap(UserShopMap userShopMapCondition,
                                         int pageIndex, int pageSize);

}
