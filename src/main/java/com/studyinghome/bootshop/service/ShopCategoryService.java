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
     * @return List<ProductCategory>
     * @throws JsonProcessingException
     * @throws IOException
     * @ long shopId
     */
    List<ShopCategory> getFirstLevelShopCategoryList() throws IOException;

    /**
     * 通过父分类id获取所有分类
     *
     * @param parentId
     * @return
     * @throws IOException
     */
    List<ShopCategory> getShopCategoryList(Long parentId) throws IOException;

    /**
     * 获取所有第二结节点的分类
     *
     * @return
     * @throws IOException
     */
    List<ShopCategory> getAllSecondLevelShopCategory() throws IOException;

    /**
     * 通过分类id获取分类内容
     *
     * @param shopCategoryId
     * @return
     */
    ShopCategory getShopCategoryById(Long shopCategoryId);

    /**
     * 添加店铺分类
     *
     * @param shopCategory
     * @param thumbnail
     * @return
     */
    ShopCategoryExecution addShopCategory(ShopCategory shopCategory,
                                          CommonsMultipartFile thumbnail);

    /**
     * 修改店铺分类
     *
     * @param shopCategory
     * @param thumbnail
     * @param thumbnailChange
     * @return
     */
    ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory,
                                             CommonsMultipartFile thumbnail, boolean thumbnailChange);

    /**
     * 删除店铺分类
     *
     * @param shopCategoryId
     * @return
     */
    ShopCategoryExecution removeShopCategory(long shopCategoryId);

    /**
     * 通过id批量删除分类
     *
     * @param shopCategoryIdList
     * @return
     */
    ShopCategoryExecution removeShopCategoryList(List<Long> shopCategoryIdList);

}
