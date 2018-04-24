package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 微信通用接口凭证 
 *  
 * @author xiangli 
 * @date 2015-02-11 
 */
@Getter
@Setter
public class AccessToken implements Serializable {
    // 获取到的凭证  
    private String token;  
    // 凭证有效时间，单位：秒  
    private int expiresIn;  
}
