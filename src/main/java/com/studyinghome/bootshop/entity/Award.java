package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 奖品
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class Award implements Serializable {
	private Long awardId;//奖品id
	private String awardName;//奖品名称
	private String awardDesc;//奖品描述
	private String awardImg;//奖品图
	private Integer point;//所需积分
	private Integer priority;//优先权(数字越大越靠前)
	private Date createTime;//创建时间
	private Date expireTime;//终止时间
	private Date lastEditTime;//最近编辑时间
	private Integer enableStatus;//开启状态(0:不显示，1:显示)
	private Long shopId;//所属店铺id
}
