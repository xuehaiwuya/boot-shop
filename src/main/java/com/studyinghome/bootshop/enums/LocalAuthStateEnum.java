package com.studyinghome.bootshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 本地验证返回状态值
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@AllArgsConstructor
public enum LocalAuthStateEnum{
	LOGINFAIL(-1, "密码或帐号输入有误"), SUCCESS(0, "操作成功"), NULL_AUTH_INFO(-1006,
			"注册信息为空"), ONLY_ONE_ACCOUNT(-1007,"最多只能绑定一个本地帐号");

	private int state;
	private String stateInfo;

	public static LocalAuthStateEnum stateOf(int index) {
		for (LocalAuthStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
