package com.studyinghome.bootshop.util.weixin.message.resp;

import com.studyinghome.bootshop.util.baidu.Point;
import lombok.Getter;
import lombok.Setter;

/** 
 * 文本消息 
 *
 * @author panxiang
 * @create 2018-04-26
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