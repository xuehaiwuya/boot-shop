package com.studyinghome.bootshop.util.weixin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 *
 * @author panxiang
 * @create 2018-04-26
 */
@Getter
@Setter
@ToString
public class WeiXinUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String openId;

	private String nickName;

	private int sex;

	private String province;

	private String city;

	private String country;

	private String headimgurl;

	private String privilege;

	private String unionid;

}
