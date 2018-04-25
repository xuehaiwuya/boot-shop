package com.studyinghome.bootshop.dto;

import com.studyinghome.bootshop.entity.LocalAuth;
import com.studyinghome.bootshop.enums.LocalAuthStateEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class LocalAuthExecution implements Serializable {
	// 结果状态
	private int state;
	// 状态标识
	private String stateInfo;
	private int count;
	private LocalAuth localAuth;
	private List<LocalAuth> localAuthList;

	// 失败的构造器
	public LocalAuthExecution(LocalAuthStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 成功的构造器
	public LocalAuthExecution(LocalAuthStateEnum stateEnum, LocalAuth localAuth) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.localAuth = localAuth;
	}

	// 成功的构造器
	public LocalAuthExecution(LocalAuthStateEnum stateEnum,
			List<LocalAuth> localAuthList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.localAuthList = localAuthList;
	}

}
