package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 按钮的基类 
 *  
 * @author xiang li 
 * @date 2015-02-11 
 */

@Getter
@Setter
public class Button implements Serializable {
    private String name;  
}
