package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 菜单 
 *
 * @author panxiang
 * @create 2018-04-26
 */
@Getter
@Setter
public class Menu implements Serializable {
    private Button[] button;  
}
