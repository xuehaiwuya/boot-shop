package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺授权信息
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class ShopAuthMap implements Serializable {
	private Long shopAuthId;//授权id
	private Long employeeId;//雇员id
	private Long shopId;//店铺id
	private String name;//雇员名称
	private String title;//职位
	private Integer titleFlag;//职位标志(决定雇员权限)
	private Integer enableStatus;//状态
	private Date createTime;//创建时间
	private Date lastEditTime;//最近编辑时间
	private PersonInfo employee;//雇员信息
	private Shop shop;//店铺信息
}
