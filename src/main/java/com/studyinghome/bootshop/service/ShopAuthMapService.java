package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.ShopAuthMapExecution;
import com.studyinghome.bootshop.entity.ShopAuthMap;

public interface ShopAuthMapService {
	/**
	 * 
	 * @param shopId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ShopAuthMapExecution listShopAuthMapByShopId(Long shopId,
                                                 Integer pageIndex, Integer pageSize);

	/**
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
	 * @ shopAuthId
	 * @ title
	 * @ titleFlag
	 * @ enableStatus
	 * @return
	 * @throws RuntimeException
	 */
	ShopAuthMapExecution modifyShopAuthMap(ShopAuthMap shopAuthMap) throws RuntimeException;

	/**
	 * 
	 * @param shopAuthMapId
	 * @return
	 * @throws RuntimeException
	 */
	ShopAuthMapExecution removeShopAuthMap(Long shopAuthMapId)
			throws RuntimeException;

	/**
	 * 
	 * @param shopAuthId
	 * @return
	 */
	ShopAuthMap getShopAuthMapById(Long shopAuthId);

}
