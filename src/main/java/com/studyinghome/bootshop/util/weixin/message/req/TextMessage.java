package com.studyinghome.bootshop.util.weixin.message.req;


import lombok.Getter;
import lombok.Setter;

/**
 * 消息基类（普通用户 -> 公众帐号）
 *
 * @author panxiang
 * @create 2018-04-26
 */
@Getter
@Setter
public class TextMessage extends BaseMessage {  
  // 消息内容  
  private String Content;  
}