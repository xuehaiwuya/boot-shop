package com.studyinghome.bootshop.util.weixin.message.resp;

import lombok.Getter;
import lombok.Setter;

/**
 * 音乐消息 
 *  
 * @author xiangli
 * @date 2015-02-10
 */
@Getter
@Setter
public class MusicMessage extends BaseMessage {
    // 音乐  
    private Music Music;  
}