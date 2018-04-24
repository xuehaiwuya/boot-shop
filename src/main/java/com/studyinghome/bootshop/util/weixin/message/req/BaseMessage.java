package com.studyinghome.bootshop.util.weixin.message.req;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 消息基类（普通用户 -> 公众帐号）
 * 
 * @author xiangli
 * @date 2015-02-10
 */

@Getter
@Setter
public class BaseMessage implements Serializable {
	// 开发者微信号
	private String ToUserName;
	// 发送方帐号（一个OpenID）
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型（text/image/location/link）
	private String MsgType;
	// 消息id，64位整型
	private long MsgId;
}