package com.studyinghome.bootshop.dto;

import com.studyinghome.bootshop.entity.UserShopMap;
import com.studyinghome.bootshop.enums.UserShopMapStateEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserShopMapExecution implements Serializable {
	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	// 授权数
	private Integer count;

	// 操作的UserShopMap
	private UserShopMap userShopMap;

	// 授权列表（查询专用）
	private List<UserShopMap> userShopMapList;

	// 失败的构造器
	public UserShopMapExecution(UserShopMapStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 成功的构造器
	public UserShopMapExecution(UserShopMapStateEnum stateEnum,
			UserShopMap userShopMap) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.userShopMap = userShopMap;
	}

	// 成功的构造器
	public UserShopMapExecution(UserShopMapStateEnum stateEnum,
			List<UserShopMap> userShopMapList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.userShopMapList = userShopMapList;
	}
}
