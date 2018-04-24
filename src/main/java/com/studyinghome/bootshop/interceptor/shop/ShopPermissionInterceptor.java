package com.studyinghome.bootshop.interceptor.shop;

import com.studyinghome.bootshop.entity.Shop;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShopPermissionInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		Shop currentShop = (Shop) request.getSession().getAttribute(
				"currentShop");
		@SuppressWarnings("unchecked")
		List<Shop> shopList = (List<Shop>) request.getSession().getAttribute(
				"shopList");
		if (currentShop != null && shopList != null) {
			for (Shop shop : shopList) {
				if (shop.getShopId() == currentShop.getShopId()) {
					return true;
				}
			}
		}
		return false;
	}
}
