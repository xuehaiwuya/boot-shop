package com.studyinghome.bootshop.util.weixin.message.resp;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 图文model 
 *
 * @author panxiang
 * @create 2018-04-26
 */
@Getter
@Setter
public class Article implements Serializable {
    // 图文消息名称  
    private String Title;  
    // 图文消息描述  
    private String Description;  
    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致  
    private String PicUrl;  
    // 点击图文消息跳转链接  
    private String Url;  
}