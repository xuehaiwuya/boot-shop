package com.studyinghome.bootshop.util.weixin.message.req;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class WechatInfo implements Serializable {
	private Long customerId;
	private Long productId;
	private Long userAwardId;
	private Long createTime;
}
