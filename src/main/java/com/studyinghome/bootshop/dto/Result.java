package com.studyinghome.bootshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 封装json对象，所有返回结果都使用它
 */
@Getter
@Setter
@NoArgsConstructor
public class Result<T> implements Serializable {
	private boolean success;// 是否成功标志
	private T data;// 成功时返回的数据
	private String errorMsg;// 错误信息
	private int errorCode;

	// 成功时的构造器
	public Result(boolean success, T data) {
		this.success = success;
		this.data = data;
	}
	// 错误时的构造器
	public Result(boolean success, int errorCode, String errorMsg) {
		this.success = success;
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}
}
