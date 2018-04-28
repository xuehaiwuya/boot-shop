package com.studyinghome.bootshop.util.weixin.message.resp;

import lombok.Getter;
import lombok.Setter;

/**
 * 音乐消息 
 *
 * @author panxiang
 * @create 2018-04-26
 */
@Getter
@Setter
public class MusicMessage extends BaseMessage {
    // 音乐  
    private Music Music;  
}