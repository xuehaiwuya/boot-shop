package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.ShopAuthMapExecution;
import com.studyinghome.bootshop.entity.ShopAuthMap;

public interface ShopAuthMapService {
    /**
     * 通过店铺id获取店铺授权信息
     *
     * @param shopId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ShopAuthMapExecution listShopAuthMapByShopId(Long shopId,
                                                 Integer pageIndex, Integer pageSize);

    /**
     * 添加店铺授权
     *
     * @param shopAuthMap
     * @return
     * @throws RuntimeException
     */
    ShopAuthMapExecution addShopAuthMap(ShopAuthMap shopAuthMap)
            throws RuntimeException;

    /**
     * 更新授权信息，包括职位等
     *
     * @return
     * @throws RuntimeException
     * @ shopAuthId
     * @ title
     * @ titleFlag
     * @ enableStatus
     */
    ShopAuthMapExecution modifyShopAuthMap(ShopAuthMap shopAuthMap) throws RuntimeException;

    /**
     * 删除授权信息
     *
     * @param shopAuthMapId
     * @return
     * @throws RuntimeException
     */
    ShopAuthMapExecution removeShopAuthMap(Long shopAuthMapId)
            throws RuntimeException;

    /**
     * 通过授权id获取授权内容
     *
     * @param shopAuthId
     * @return
     */
    ShopAuthMap getShopAuthMapById(Long shopAuthId);

}
