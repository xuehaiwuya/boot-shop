package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class ShopCategory implements Serializable {
	private Long shopCategoryId;
	private String shopCategoryName;
	private String shopCategoryDesc;
	private String shopCategoryImg;
	private Integer priority;
	private Date createTime;
	private Date lastEditTime;
	private Long parentId;
}
