package com.studyinghome.bootshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户店铺操作返回状态值
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@AllArgsConstructor
public enum UserShopMapStateEnum {
	SUCCESS(1, "操作成功"), INNER_ERROR(-1001, "操作失败"), NULL_USERSHOP_ID(-1002,
			"UserShopId为空"), NULL_USERSHOP_INFO(-1003, "传入了空的信息");

	private int state;
	private String stateInfo;

	public static UserShopMapStateEnum stateOf(int index) {
		for (UserShopMapStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
