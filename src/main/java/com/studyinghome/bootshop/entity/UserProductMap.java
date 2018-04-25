package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户购买产品信息
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class UserProductMap implements Serializable {
	private Long userProductId;//主键id
	private Long userId;//用户id
	private Long productId;//产品id
	private Long shopId;//店铺id
	private String userName;//用户名
	private String productName;//产品名
	private Date createTime;//创建时间
	private Integer point;//积分
	private PersonInfo user;//用户信息
	private Product product;//产品信息
	private Shop shop;//店铺信息
}
