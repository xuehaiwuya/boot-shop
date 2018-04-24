package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class WechatAuth implements Serializable {
	private Long wechatAuthId;
	private Long userId;
	private String openId;
	private Date createTime;
	private PersonInfo personInfo;
}
