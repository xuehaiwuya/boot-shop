package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductDao {

    //查询商品列表并分页，可输入的条件有：商品名（模糊），商品状态，店铺Id,商品类别
    List<Product> queryProductList(
            @Param("productCondition") Product productCondition,
            @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    //查询对应的商品总数
    int queryProductCount(@Param("productCondition") Product productCondition);

    Product queryProductByProductId(long productId);

    int insertProduct(Product product);

    int updateProduct(Product product);

    //删除商品类别之前，将商品类别ID置为空
    int updateProductCategoryToNull(long productCategoryId);

    int deleteProduct(@Param("productId") long productId,
                      @Param("shopId") long shopId);
}
