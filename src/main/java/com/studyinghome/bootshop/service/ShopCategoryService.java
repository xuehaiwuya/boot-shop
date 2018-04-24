package com.studyinghome.bootshop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studyinghome.bootshop.dto.ShopCategoryExecution;
import com.studyinghome.bootshop.entity.ShopCategory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.List;

public interface ShopCategoryService {
	/**
	 * 查询指定某个店铺下的所有商品类别信息
	 * 
	 * @ long shopId
	 * @return List<ProductCategory>
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	List<ShopCategory> getFirstLevelShopCategoryList() throws IOException;

	/**
	 * 
	 * @param parentId
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getShopCategoryList(Long parentId) throws IOException;

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getAllSecondLevelShopCategory() throws IOException;

	/**
	 * 
	 * @param shopCategoryId
	 * @return
	 */
	ShopCategory getShopCategoryById(Long shopCategoryId);

	/**
	 * 
	 * @param shopCategory
	 * @param thumbnail
	 * @return
	 */
	ShopCategoryExecution addShopCategory(ShopCategory shopCategory,
                                          CommonsMultipartFile thumbnail);

	/**
	 *
	 * @param shopCategory
	 * @param thumbnail
	 * @param thumbnailChange
	 * @return
	 */
	ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory,
                                             CommonsMultipartFile thumbnail, boolean thumbnailChange);

	/**
	 * 
	 * @param shopCategoryId
	 * @return
	 */
	ShopCategoryExecution removeShopCategory(long shopCategoryId);

	/**
	 * 
	 * @param shopCategoryIdList
	 * @return
	 */
	ShopCategoryExecution removeShopCategoryList(List<Long> shopCategoryIdList);

}
