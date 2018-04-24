package com.studyinghome.bootshop.web.frontend;

import com.studyinghome.bootshop.dto.UserProductMapExecution;
import com.studyinghome.bootshop.entity.PersonInfo;
import com.studyinghome.bootshop.entity.UserProductMap;
import com.studyinghome.bootshop.service.UserProductMapService;
import com.studyinghome.bootshop.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/frontend")
public class MyProductController {
	@Autowired
	private UserProductMapService userProductMapService;

	@RequestMapping(value = "/listuserproductmapsbycustomer", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listUserProductMapsByCustomer(
			HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
		int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
		PersonInfo user = (PersonInfo) request.getSession()
				.getAttribute("user");
		if ((pageIndex > -1) && (pageSize > -1) && (user != null)
				&& (user.getUserId() != -1)) {
			UserProductMap userProductMapCondition = new UserProductMap();
			userProductMapCondition.setUserId(user.getUserId());
			long shopId = HttpServletRequestUtil.getLong(request, "shopId");
			if (shopId > -1) {
				userProductMapCondition.setShopId(shopId);
			}
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
}
