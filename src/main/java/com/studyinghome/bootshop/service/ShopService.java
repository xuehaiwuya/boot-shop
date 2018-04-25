package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.ShopExecution;
import com.studyinghome.bootshop.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface ShopService {

	ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

	/**
	 * 查询该用户下面的店铺信息
	 * 
	 * @param employeeId
	 * @return List<Shop>
	 * @throws Exception
	 */
	ShopExecution getByEmployeeId(long employeeId) throws RuntimeException;

	/**
	 * 查询指定店铺信息
	 * 
	 * @param shopId
	 * @return Shop shop
	 */
	Shop getByShopId(long shopId);

	/**
	 * 创建商铺
	 * 
	 * @param shop
	 * @return ShopExecution shopExecution
	 * @throws Exception
	 */
	ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException;

	/**
	 * 更新店铺信息（从店家角度）
	 * 
	 * @return
	 * @throws RuntimeException
	 */
	ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException;

}
