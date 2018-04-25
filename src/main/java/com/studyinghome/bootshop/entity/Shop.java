package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 店铺信息
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class Shop implements Serializable {
	private Long shopId;//店铺id
	private Long ownerId;//账号id
	private Long shopCategoryId;//店铺类别id
	private String shopName;//店铺名称
	private String shopDesc;//店铺描述
	private String shopAddr;//详细地址
	private String phone;//店铺联系电话
	private String shopImg;//店铺图片
	private Double longitude;//经度
	private Double latitude;//纬度
	private Integer priority;//优先级
	private Date createTime;//创建时间
	private Date lastEditTime;//最近编辑时间
	private Integer enableStatus;//店铺状态(0:禁用，1:启用，2:审核中)
	private String advice;//建议

	private List<ShopAuthMap> staffList;//店铺职员
	private Area area;//店铺所属区域
	private ShopCategory shopCategory;//店铺分类
	private ShopCategory parentCategory;//商品分类
}
