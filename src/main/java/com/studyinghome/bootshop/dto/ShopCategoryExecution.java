package com.studyinghome.bootshop.dto;

import com.studyinghome.bootshop.entity.ShopCategory;
import com.studyinghome.bootshop.enums.ShopCategoryStateEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShopCategoryExecution implements Serializable {
	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	private ShopCategory shopCategory;

	// 操作的商铺类别
	private List<ShopCategory> shopCategoryList;


	public ShopCategoryExecution(ShopCategoryStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	public ShopCategoryExecution(ShopCategoryStateEnum stateEnum,
			ShopCategory shopCategory) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopCategory = shopCategory;
	}

	public ShopCategoryExecution(ShopCategoryStateEnum stateEnum,
			List<ShopCategory> shopCategoryList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopCategoryList = shopCategoryList;
	}
}
