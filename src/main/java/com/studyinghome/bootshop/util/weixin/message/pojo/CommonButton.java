package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 普通按钮（子按钮） 
 *
 * @author panxiang
 * @create 2018-04-26
 */
@Getter
@Setter
public class CommonButton extends Button {  
    private String type;  
    private String key;  
}
