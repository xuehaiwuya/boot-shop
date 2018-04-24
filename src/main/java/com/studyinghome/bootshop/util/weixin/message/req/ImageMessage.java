package com.studyinghome.bootshop.util.weixin.message.req;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片消息 
 *  
 * @author xiangli
 * @date 2015-02-10
 */
@Setter
@Getter
public class ImageMessage extends BaseMessage {
    // 图片链接  
    private String PicUrl;  
}