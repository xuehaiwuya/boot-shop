package com.studyinghome.bootshop.dto;

import com.studyinghome.bootshop.entity.Product;
import com.studyinghome.bootshop.enums.ProductStateEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductExecution implements Serializable {
	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	// 店铺数量
	private int count;

	// 操作的product（增删改商品的时候用）
	private Product product;

	// 获取的product列表(查询商品列表的时候用)
	private List<Product> productList;

	// 失败的构造器
	public ProductExecution(ProductStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 成功的构造器
	public ProductExecution(ProductStateEnum stateEnum, Product product) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.product = product;
	}

	// 成功的构造器
	public ProductExecution(ProductStateEnum stateEnum,
			List<Product> productList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.productList = productList;
	}

}
