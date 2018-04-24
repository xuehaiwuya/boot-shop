package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 普通按钮（子按钮） 
 *  
 * @author xiangli 
 * @date 2015-02-11 
 */
@Getter
@Setter
public class CommonButton extends Button {  
    private String type;  
    private String key;  
}
