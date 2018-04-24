package com.studyinghome.bootshop.web.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studyinghome.bootshop.dto.ShopAuthMapExecution;
import com.studyinghome.bootshop.dto.UserProductMapExecution;
import com.studyinghome.bootshop.entity.*;
import com.studyinghome.bootshop.enums.UserProductMapStateEnum;
import com.studyinghome.bootshop.service.PersonInfoService;
import com.studyinghome.bootshop.service.ProductService;
import com.studyinghome.bootshop.service.ShopAuthMapService;
import com.studyinghome.bootshop.service.UserProductMapService;
import com.studyinghome.bootshop.util.HttpServletRequestUtil;
import com.studyinghome.bootshop.util.weixin.message.req.WechatInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class UserProductManagementController {
	@Autowired
	private UserProductMapService userProductMapService;
	@Autowired
	private PersonInfoService personInfoService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ShopAuthMapService shopAuthMapService;

	@RequestMapping(value = "/listuserproductmapsbyshop", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listUserProductMapsByShop(
			HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
		int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
		Shop currentShop = (Shop) request.getSession().getAttribute(
				"currentShop");
		if ((pageIndex > -1) && (pageSize > -1) && (currentShop != null)
				&& (currentShop.getShopId() != null)) {
			UserProductMap userProductMapCondition = new UserProductMap();
			userProductMapCondition.setShopId(currentShop.getShopId());
			String productName = HttpServletRequestUtil.getString(request,
					"productName");
			if (productName != null) {
				userProductMapCondition.setProductName(productName);
			}
			UserProductMapExecution ue = userProductMapService
					.listUserProductMap(userProductMapCondition, pageIndex,
							pageSize);
			modelMap.put("userProductMapList", ue.getUserProductMapList());
			modelMap.put("count", ue.getCount());
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
		}
		return modelMap;
	}

	@RequestMapping(value = "/adduserproductmap", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> addUserProductMap(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		PersonInfo user = (PersonInfo) request.getSession()
				.getAttribute("user");
		String qrCodeinfo = HttpServletRequestUtil.getString(request, "state");
		ObjectMapper mapper = new ObjectMapper();
		WechatInfo wechatInfo = null;
		try {
			wechatInfo = mapper.readValue(qrCodeinfo, WechatInfo.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}
		if (!checkQRCodeInfo(wechatInfo)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "二维码信息非法！");
			return modelMap;
		}
		Long productId = wechatInfo.getProductId();
		Long customerId = wechatInfo.getCustomerId();
		UserProductMap userProductMap = compactUserProductMap4Add(customerId,
				productId);
		if (userProductMap != null && customerId != -1) {
			try {
				if (!checkShopAuth(user.getUserId(), userProductMap)) {
					modelMap.put("success", false);
					modelMap.put("errMsg", "无操作权限");
					return modelMap;
				}
				UserProductMapExecution se = userProductMapService
						.addUserProductMap(userProductMap);
				if (se.getState() == UserProductMapStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", se.getStateInfo());
				}
			} catch (RuntimeException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}

		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入授权信息");
		}
		return modelMap;
	}

	private boolean checkQRCodeInfo(WechatInfo wechatInfo) {
		if (wechatInfo != null && wechatInfo.getProductId() != null
				&& wechatInfo.getCustomerId() != null
				&& wechatInfo.getCreateTime() != null) {
			long nowTime = System.currentTimeMillis();
			if ((nowTime - wechatInfo.getCreateTime()) <= 5000) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private UserProductMap compactUserProductMap4Add(Long customerId,
			Long productId) {
		UserProductMap userProductMap = null;
		if (customerId != null && productId != null) {
			userProductMap = new UserProductMap();
			PersonInfo personInfo = personInfoService
					.getPersonInfoById(customerId);
			Product product = productService.getProductById(productId);
			userProductMap.setProductId(productId);
			userProductMap.setShopId(product.getShop().getShopId());
			userProductMap.setProductName(product.getProductName());
			userProductMap.setUserName(personInfo.getName());
			userProductMap.setPoint(product.getPoint());
			userProductMap.setCreateTime(new Date());
		}
		return userProductMap;
	}

	private boolean checkShopAuth(long userId, UserProductMap userProductMap) {
		ShopAuthMapExecution shopAuthMapExecution = shopAuthMapService
				.listShopAuthMapByShopId(userProductMap.getShopId(), 1, 1000);
		for (ShopAuthMap shopAuthMap : shopAuthMapExecution
				.getShopAuthMapList()) {
			if (shopAuthMap.getEmployeeId() == userId) {
				return true;
			}
		}
		return false;
	}
}
