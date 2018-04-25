package com.studyinghome.bootshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户奖品操作返回状态
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@AllArgsConstructor
public enum UserAwardMapStateEnum {
	SUCCESS(1, "操作成功"), INNER_ERROR(-1001, "操作失败"), NULL_USERAWARD_ID(-1002,
			"UserAwardId为空"), NULL_USERAWARD_INFO(-1003, "传入了空的信息");

	private int state;
	private String stateInfo;

	public static UserAwardMapStateEnum stateOf(int index) {
		for (UserAwardMapStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
