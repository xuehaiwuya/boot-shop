package com.studyinghome.bootshop.util.weixin.message.req;

import lombok.Getter;
import lombok.Setter;

/**
 * 音频消息 
 *
 * @author panxiang
 * @create 2018-04-26
 */
@Getter
@Setter
public class VoiceMessage extends BaseMessage {  
    // 媒体ID  
    private String MediaId;  
    // 语音格式  
    private String Format;  
}