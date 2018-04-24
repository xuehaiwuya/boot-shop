package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 菜单 
 *  
 * @author xiangli 
 * @date 2015-02-11 
 */
@Getter
@Setter
public class Menu implements Serializable {
    private Button[] button;  
}
