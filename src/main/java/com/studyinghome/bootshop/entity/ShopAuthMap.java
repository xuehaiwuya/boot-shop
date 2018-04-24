package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class ShopAuthMap implements Serializable {
	private Long shopAuthId;
	private Long employeeId;
	private Long shopId;
	private String name;
	private String title;
	private Integer titleFlag;
	private Integer enableStatus;
	private Date createTime;
	private Date lastEditTime;
	private PersonInfo employee;
	private Shop shop;
}
