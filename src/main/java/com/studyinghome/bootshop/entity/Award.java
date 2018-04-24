package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Award implements Serializable {
	private Long awardId;
	private String awardName;
	private String awardDesc;
	private String awardImg;
	private Integer point;
	private Integer priority;
	private Date createTime;
	private Date expireTime;
	private Date lastEditTime;
	private Integer enableStatus;
	private Long shopId;
}
