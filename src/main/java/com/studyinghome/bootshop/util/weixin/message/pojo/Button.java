package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 按钮的基类 
 *
 * @author panxiang
 * @create 2018-04-26
 */

@Getter
@Setter
public class Button implements Serializable {
    private String name;  
}
