package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Area implements Serializable {
	private Long areaId;
	private String areaName;
	private String areaDesc;
	private Integer priority;
	private Date createTime;
	private Date lastEditTime;
}
