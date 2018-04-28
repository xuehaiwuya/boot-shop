package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;

/**
* view类型的菜单 
*
 * @author panxiang
 * @create 2018-04-26
 */
@Getter
@Setter
public class ViewButton extends Button {  
   private String type;  
   private String url;  
}