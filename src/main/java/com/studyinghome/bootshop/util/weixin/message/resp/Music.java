package com.studyinghome.bootshop.util.weixin.message.resp;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 音乐model 
 *  
 * @author xiangli
 * @date 2015-02-10 
 */
@Getter
@Setter
public class Music implements Serializable {
    // 音乐名称  
    private String Title;  
    // 音乐描述  
    private String Description;  
    // 音乐链接  
    private String MusicUrl;  
    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐  
    private String HQMusicUrl;  
}