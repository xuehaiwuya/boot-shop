package com.studyinghome.bootshop.util.weixin.message.resp;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 消息基类（公众帐号 -> 普通用户）
 * 
 * @author xiangli
 * @date 2015-02-10
 */
@Getter
@Setter
public class BaseMessage implements Serializable {
	// 接收方帐号（收到的OpenID）
	private String ToUserName;
	// 开发者微信号
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型（text/music/news）
	private String MsgType;
	// 位0x0001被标志时，星标刚收到的消息
	private int FuncFlag;
}