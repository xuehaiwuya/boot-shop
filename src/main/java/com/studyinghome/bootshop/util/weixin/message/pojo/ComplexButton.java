package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 复杂按钮（父按钮） 
 *
 * @author panxiang
 * @create 2018-04-26
 */
@Getter
@Setter
public class ComplexButton extends Button {  
    private Button[] sub_button;  
}