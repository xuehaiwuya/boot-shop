package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductCategoryDao {
    List<ProductCategory> queryByShopId(long shopId);

    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    //删除商品类别（初版，即只支持删除尚且没有发布商品的商品类别）
    int deleteProductCategory(
            @Param("productCategoryId") long productCategoryId,
            @Param("shopId") long shopId);
}
