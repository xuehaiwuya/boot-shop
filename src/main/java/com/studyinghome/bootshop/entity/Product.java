package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品信息
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class Product implements Serializable{
	private Long productId;//商品id
	private String productName;//商品名
	private String productDesc;//商品描述
	private String imgAddr;// 简略图地址
	private String normalPrice;//原价
	private String promotionPrice;//现价
	private Integer priority;//优先级
	private Date createTime;//创建时间
	private Date lastEditTime;//最近编辑时间
	private Integer enableStatus;//商品状态
	private Integer point;//所需积分

	private List<ProductImg> productImgList;//商品详情图片
	private ProductCategory productCategory;//商品类别信息
	private Shop shop;//商品所属店铺
}
