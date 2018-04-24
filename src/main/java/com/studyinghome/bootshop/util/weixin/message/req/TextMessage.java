package com.studyinghome.bootshop.util.weixin.message.req;


import lombok.Getter;
import lombok.Setter;

/**
 * 消息基类（普通用户 -> 公众帐号）
 * 
 * @author xiangli
 * @date 2015-02-10
 */
@Getter
@Setter
public class TextMessage extends BaseMessage {  
  // 消息内容  
  private String Content;  
}