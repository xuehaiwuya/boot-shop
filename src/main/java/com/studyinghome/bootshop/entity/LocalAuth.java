package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 *本地身份验证
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class LocalAuth implements Serializable {
	private Long localAuthId;//本地身份id
	private String userName;//用户名
	private String password;//密码
	private Long userId;//用户id
	private Date createTime;//创建时间
	private Date lastEditTime;//最近编辑时间
	private PersonInfo personInfo;//个人信息
}
