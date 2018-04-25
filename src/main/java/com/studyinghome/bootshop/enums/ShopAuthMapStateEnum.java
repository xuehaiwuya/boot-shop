package com.studyinghome.bootshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 店铺雇员验证
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@AllArgsConstructor
public enum ShopAuthMapStateEnum {
	SUCCESS(1, "操作成功"), INNER_ERROR(-1001, "操作失败"), NULL_SHOPAUTH_ID(-1002,
			"ShopAuthId为空"), NULL_SHOPAUTH_INFO(-1003, "传入了空的信息");

	private int state;
	private String stateInfo;

	public static ShopAuthMapStateEnum stateOf(int index) {
		for (ShopAuthMapStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
