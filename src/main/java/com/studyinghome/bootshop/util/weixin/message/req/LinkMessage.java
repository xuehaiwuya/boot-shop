package com.studyinghome.bootshop.util.weixin.message.req;

import lombok.Getter;
import lombok.Setter;

/**
 * 链接消息 
 *
 * @author panxiang
 * @create 2018-04-26
 */
@Getter
@Setter
public class LinkMessage extends BaseMessage {  
    // 消息标题  
    private String Title;  
    // 消息描述  
    private String Description;  
    // 消息链接  
    private String Url;  
}