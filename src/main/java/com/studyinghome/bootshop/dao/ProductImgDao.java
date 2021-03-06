package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.ProductImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductImgDao {

	List<ProductImg> queryProductImgList(long productId);

	int batchInsertProductImg(List<ProductImg> productImgList);

	int deleteProductImgByProductId(long productId);
}
