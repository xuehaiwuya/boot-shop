package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Product implements Serializable{
	private static final long serialVersionUID = -349433539553804024L;
	private Long productId;
	private String productName;
	private String productDesc;
	private String imgAddr;// 简略图
	private String normalPrice;
	private String promotionPrice;
	private Integer priority;
	private Date createTime;
	private Date lastEditTime;
	private Integer enableStatus;
	private Integer point;

	private List<ProductImg> productImgList;
	private ProductCategory productCategory;
	private Shop shop;
}
