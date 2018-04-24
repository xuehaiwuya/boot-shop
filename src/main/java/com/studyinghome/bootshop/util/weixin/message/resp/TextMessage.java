package com.studyinghome.bootshop.util.weixin.message.resp;

import com.studyinghome.bootshop.util.baidu.Point;
import lombok.Getter;
import lombok.Setter;

/** 
 * 文本消息 
 *  
 * @author xiangli
 * @date 2015-02-10
 */
@Getter
@Setter
public class TextMessage extends BaseMessage {  
    // 回复的消息内容  
    private String Content;  
    //坐标点
    private Point point;
    //openId
    private String openId;
}  