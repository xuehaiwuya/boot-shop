package com.studyinghome.bootshop.util.weixin.message.req;

import lombok.Getter;
import lombok.Setter;

/**
 * 链接消息 
 *  
 * @author xiangli
 * @date 2015-02-10
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