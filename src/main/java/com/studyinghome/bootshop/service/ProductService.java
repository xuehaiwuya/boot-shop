package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.ProductExecution;
import com.studyinghome.bootshop.entity.Product;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

public interface ProductService {
    /**
     * 分页获取所有商品列表
     *
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

    /**
     * 通过商品id获取商品
     *
     * @param productId
     * @return
     */
    Product getProductById(long productId);

    /**
     * 添加商品
     *
     * @param product
     * @param thumbnail
     * @param productImgs
     * @return
     * @throws RuntimeException
     */
    ProductExecution addProduct(Product product, CommonsMultipartFile thumbnail, List<CommonsMultipartFile> productImgs)
            throws RuntimeException;

    /**
     * 更新商品信息
     *
     * @param product
     * @param thumbnail
     * @param productImgs
     * @return
     * @throws RuntimeException
     */
    ProductExecution modifyProduct(Product product, CommonsMultipartFile thumbnail,
                                   List<CommonsMultipartFile> productImgs) throws RuntimeException;
}
