package com.studyinghome.bootshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 奖品操作状态返回信息
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@AllArgsConstructor
public enum AwardStateEnum {
	OFFLINE(-1, "非法奖品"), SUCCESS(0, "操作成功"), INNER_ERROR(-1001, "操作失败"), EMPTY(
			-1002, "奖品信息为空");

	private int state;
	private String stateInfo;

	public static AwardStateEnum stateOf(int index) {
		for (AwardStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
