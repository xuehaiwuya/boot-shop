package com.studyinghome.bootshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 头条信息操作返回状态值
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@AllArgsConstructor
public enum HeadLineStateEnum {
	SUCCESS(0, "创建成功"), INNER_ERROR(-1001, "操作失败"), EMPTY(-1002, "头条信息为空");

	private int state;
	private String stateInfo;

	public static HeadLineStateEnum stateOf(int index) {
		for (HeadLineStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
