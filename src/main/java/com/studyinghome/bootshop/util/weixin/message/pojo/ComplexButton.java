package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 复杂按钮（父按钮） 
 *  
 * @author xiangli 
 * @date 2015-02-11 
 */
@Getter
@Setter
public class ComplexButton extends Button {  
    private Button[] sub_button;  
}