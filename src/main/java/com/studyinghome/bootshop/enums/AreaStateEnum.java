package com.studyinghome.bootshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 地域操作状态返回信息
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@AllArgsConstructor
public enum AreaStateEnum {
	OFFLINE(-1, "非法区域"), SUCCESS(0, "操作成功"), INNER_ERROR(-1001, "操作失败"), EMPTY(
			-1002, "区域信息为空");

	private int state;
	private String stateInfo;

	public static AreaStateEnum stateOf(int index) {
		for (AreaStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
