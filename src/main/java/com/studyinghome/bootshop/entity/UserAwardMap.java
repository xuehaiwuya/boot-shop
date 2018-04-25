package com.studyinghome.bootshop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户兑换奖品信息
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@Setter
@ToString
public class UserAwardMap implements Serializable {
	private Long userAwardId;//主键id
	private Long userId;//用户id
	private Long awardId;//奖品id
	private Long shopId;//奖品所属店铺id
	private String userName;//用户名
	private String awardName;//奖品名
	private Date expireTime;//终止时间
	private Date createTime;//创建时间
	private Integer usedStatus;//使用状态
	private Integer point;//所需积分
	private PersonInfo user;//用户信息
	private Award award;//奖品信息
	private Shop shop;//店铺信息
}
