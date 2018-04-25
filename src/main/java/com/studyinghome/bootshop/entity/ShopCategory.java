package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 *店铺类别
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Setter
@Getter
@ToString
public class ShopCategory implements Serializable {
	private Long shopCategoryId;//店铺类别id
	private String shopCategoryName;//店铺类别名称
	private String shopCategoryDesc;//店铺类别描述
	private String shopCategoryImg;//店铺类别图片
	private Integer priority;//优先级
	private Date createTime;//创建时间
	private Date lastEditTime;//最近编辑时间
	private Long parentId;//上级类别id
}
