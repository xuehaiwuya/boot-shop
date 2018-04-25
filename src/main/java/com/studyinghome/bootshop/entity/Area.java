package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 地域
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class Area implements Serializable {
	private Long areaId;//地域id
	private String areaName;//地域名称
	private String areaDesc;//地域描述
	private Integer priority;//优先权
	private Date createTime;//创建时间
	private Date lastEditTime;//最近编辑时间
}
