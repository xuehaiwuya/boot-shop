package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 *用户详细信息
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class PersonInfo implements Serializable {
	private Long userId;//用户账号id
	private String name;//用户名
	private Date birthday;//出生日期
	private String gender;//性别
	private String phone;//联系方式
	private String email;//邮箱
	private String profileImg;//用户头像
	private Integer customerFlag;//普通顾客标识(只有普通用户的权限)
	private Integer shopOwnerFlag;//商家标识(商家权限)
	private Integer adminFlag;//管理员标识
	private Date createTime;//创建时间
	private Date lastEditTime;//最近编辑时间
	private Integer enableStatus;//状态
}
