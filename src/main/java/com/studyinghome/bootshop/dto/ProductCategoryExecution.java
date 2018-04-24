package com.studyinghome.bootshop.dto;

import com.studyinghome.bootshop.entity.ProductCategory;
import com.studyinghome.bootshop.enums.ProductCategoryStateEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductCategoryExecution implements Serializable {
	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	// 操作的商铺类别
	private List<ProductCategory> productCategoryList;

	// 预约失败的构造器
	public ProductCategoryExecution(ProductCategoryStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 预约成功的构造器
	public ProductCategoryExecution(ProductCategoryStateEnum stateEnum,
			List<ProductCategory> productCategoryList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.productCategoryList = productCategoryList;
	}

}
