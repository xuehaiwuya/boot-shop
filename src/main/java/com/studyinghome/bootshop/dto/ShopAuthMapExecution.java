package com.studyinghome.bootshop.dto;

import com.studyinghome.bootshop.entity.ShopAuthMap;
import com.studyinghome.bootshop.enums.ShopAuthMapStateEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShopAuthMapExecution implements Serializable {
	// 结果状态
	private int state;
	// 状态标识
	private String stateInfo;
	// 授权数
	private Integer count;
	// 操作的shopAuthMap
	private ShopAuthMap shopAuthMap;
	// 授权列表（查询专用）
	private List<ShopAuthMap> shopAuthMapList;

	// 失败的构造器
	public ShopAuthMapExecution(ShopAuthMapStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 成功的构造器
	public ShopAuthMapExecution(ShopAuthMapStateEnum stateEnum,
			ShopAuthMap shopAuthMap) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopAuthMap = shopAuthMap;
	}

	// 成功的构造器
	public ShopAuthMapExecution(ShopAuthMapStateEnum stateEnum,
			List<ShopAuthMap> shopAuthMapList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopAuthMapList = shopAuthMapList;
	}
}
