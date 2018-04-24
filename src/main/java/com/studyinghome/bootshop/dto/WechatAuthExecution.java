package com.studyinghome.bootshop.dto;

import com.studyinghome.bootshop.entity.WechatAuth;
import com.studyinghome.bootshop.enums.WechatAuthStateEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WechatAuthExecution implements Serializable {
	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	private int count;

	private WechatAuth wechatAuth;

	private List<WechatAuth> wechatAuthList;

	// 失败的构造器
	public WechatAuthExecution(WechatAuthStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 成功的构造器
	public WechatAuthExecution(WechatAuthStateEnum stateEnum, WechatAuth wechatAuth) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.wechatAuth = wechatAuth;
	}

	// 成功的构造器
	public WechatAuthExecution(WechatAuthStateEnum stateEnum,
			List<WechatAuth> wechatAuthList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.wechatAuthList = wechatAuthList;
	}
}
