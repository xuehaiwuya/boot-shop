package com.studyinghome.bootshop.dto;

import com.studyinghome.bootshop.entity.UserProductMap;
import com.studyinghome.bootshop.enums.UserProductMapStateEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserProductMapExecution implements Serializable {
	// 结果状态
	private int state;
	// 状态标识
	private String stateInfo;
	// 授权数
	private Integer count;
	// 操作的shopAuthMap
	private UserProductMap userProductMap;
	// 授权列表（查询专用）
	private List<UserProductMap> userProductMapList;

	// 失败的构造器
	public UserProductMapExecution(UserProductMapStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 成功的构造器
	public UserProductMapExecution(UserProductMapStateEnum stateEnum,
			UserProductMap userProductMap) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.userProductMap = userProductMap;
	}

	// 成功的构造器
	public UserProductMapExecution(UserProductMapStateEnum stateEnum,
			List<UserProductMap> userProductMapList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.userProductMapList = userProductMapList;
	}
}
