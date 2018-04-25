package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺商品类别
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class ProductCategory implements Serializable {
	private Long productCategoryId;//商品类别id
	private Long shopId;//店铺id
	private String productCategoryName;//类别名称
	private String productCategoryDesc;//类别描述
	private Integer priority;//优先级
	private Date createTime;//创建时间
	private Date lastEditTime;//最近编辑时间
}
