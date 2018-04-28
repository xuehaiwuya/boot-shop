package com.studyinghome.bootshop.util.weixin.message.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户授权token
 *
 * @author panxiang
 * @create 2018-04-26
 */
@Getter
@Setter
@ToString
public class UserAccessToken implements Serializable {
	private String accessToken;
	private String expiresIn;
	private String refreshToken;
	private String openId;
	private String scope;

}
