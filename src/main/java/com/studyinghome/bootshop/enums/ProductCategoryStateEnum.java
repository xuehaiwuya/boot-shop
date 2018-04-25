package com.studyinghome.bootshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 产品类别操作状态返回值
 *
 * @author panxiang
 * @create 2018-04-25
 */
@Getter
@AllArgsConstructor
public enum ProductCategoryStateEnum {
	SUCCESS(1, "创建成功"), INNER_ERROR(-1001, "操作失败"), EMPTY_LIST(-1002, "添加数少于1");

	private int state;
	private String stateInfo;

	public static ProductCategoryStateEnum stateOf(int index) {
		for (ProductCategoryStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
