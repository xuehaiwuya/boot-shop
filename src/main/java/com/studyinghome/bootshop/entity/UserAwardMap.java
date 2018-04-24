package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class UserAwardMap implements Serializable {
	private Long userAwardId;
	private Long userId;
	private Long awardId;
	private Long shopId;
	private String userName;
	private String awardName;
	private Date expireTime;
	private Date createTime;
	private Integer usedStatus;
	private Integer point;
	private PersonInfo user;
	private Award award;
	private Shop shop;
}
