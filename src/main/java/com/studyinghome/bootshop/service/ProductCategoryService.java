package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.ProductCategoryExecution;
import com.studyinghome.bootshop.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 查询指定某个店铺下的所有商品类别信息
     *
     * @param shopId
     * @return List<ProductCategory>
     */
    List<ProductCategory> getByShopId(long shopId);

    /**
     * 添加商品类别分支
     *
     * @param productCategoryList
     * @return
     * @throws RuntimeException
     */
    ProductCategoryExecution batchAddProductCategory(
            List<ProductCategory> productCategoryList) throws RuntimeException;

    /**
     * 通过商品id删除商品类别
     *
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws RuntimeException
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId,
                                                   long shopId) throws RuntimeException;
}
