package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;

/**
* view类型的菜单 
*  
* @author xiangli 
* @date 2015-02-11 
*/
@Getter
@Setter
public class ViewButton extends Button {  
   private String type;  
   private String url;  
}