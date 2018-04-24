package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class UserShopMap implements Serializable {
	private Long userShopId;
	private Long userId;
	private Long shopId;
	private String userName;
	private String shopName;
	private Date createTime;
	private Integer point;
	private PersonInfo user;
	private Product product;
	private Shop shop;
}
