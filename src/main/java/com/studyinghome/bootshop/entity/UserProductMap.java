package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class UserProductMap implements Serializable {
	private Long userProductId;
	private Long userId;
	private Long productId;
	private Long shopId;
	private String userName;
	private String productName;
	private Date createTime;
	private Integer point;
	private PersonInfo user;
	private Product product;
	private Shop shop;
}
