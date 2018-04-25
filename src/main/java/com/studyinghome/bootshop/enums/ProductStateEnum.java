package com.studyinghome.bootshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 产品操作返回值
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@AllArgsConstructor
public enum ProductStateEnum {
	OFFLINE(-1, "非法商品"), SUCCESS(0, "操作成功"), PASS(2, "通过认证"), INNER_ERROR(
			-1001, "操作失败"),EMPTY(-1002, "商品为空");

	private int state;
	private String stateInfo;

	public static ProductStateEnum stateOf(int index) {
		for (ProductStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
