package com.studyinghome.bootshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 微信验证操作返回状态值
 */
@Getter
@AllArgsConstructor
public enum WechatAuthStateEnum {
	LOGINFAIL(-1, "openId输入有误"), SUCCESS(0, "操作成功"), NULL_AUTH_INFO(-1006,
			"注册信息为空");

	private int state;
	private String stateInfo;

	public static WechatAuthStateEnum stateOf(int index) {
		for (WechatAuthStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
