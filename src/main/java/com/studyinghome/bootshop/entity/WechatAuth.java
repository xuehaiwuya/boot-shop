package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信开发验证
 *
 * @author panxiang
 * @create 2018-04-25
 */
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
