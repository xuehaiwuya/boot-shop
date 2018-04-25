package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品详情图片
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class ProductImg implements Serializable {
	private Long productImgId;//产品图id
	private String imgAddr;//商品图片地址
	private String imgDesc;//图片描述
	private Integer priority;//优先级
	private Date createTime;//创建时间
	private Long productId;//对应的商品id
}
