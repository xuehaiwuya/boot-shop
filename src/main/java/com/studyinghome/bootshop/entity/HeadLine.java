package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 头条
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class HeadLine implements Serializable {
	private Long lineId;//头条id
	private String lineName;//头条名称
	private String lineLink;//头条链接
	private String lineImg;//头条图片
	private Integer priority;//优先权(数字越大越靠前)
	private Integer enableStatus;//头条状态(0:禁用，1:启用)
	private Date createTime;//创建时间
	private Date lastEditTime;//最近编辑时间
}
