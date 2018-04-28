package com.studyinghome.bootshop.util.weixin.message.req;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片消息 
 *
 * @author panxiang
 * @create 2018-04-26
 */
@Setter
@Getter
public class ImageMessage extends BaseMessage {
    // 图片链接  
    private String PicUrl;  
}