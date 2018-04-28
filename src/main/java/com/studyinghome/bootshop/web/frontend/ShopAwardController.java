package com.studyinghome.bootshop.web.frontend;

import com.studyinghome.bootshop.dto.AwardExecution;
import com.studyinghome.bootshop.entity.Award;
import com.studyinghome.bootshop.service.AwardService;
import com.studyinghome.bootshop.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/frontend")
public class ShopAwardController {
	@Autowired
	private AwardService awardService;

    @GetMapping(value = "/getawardbyid")
	private Map<String, Object> getAwardbyId(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();
		long awardId = HttpServletRequestUtil.getLong(request, "awardId");
		if (awardId > -1) {
			Award award = awardService.getAwardById(awardId);
			modelMap.put("award", award);
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty awardId");
		}
		return modelMap;
	}

    @GetMapping(value = "/listawardsbyshop")
	private Map<String, Object> listAwardsByShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();
		int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
		int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
		long shopId = HttpServletRequestUtil.getLong(request, "shopId");
		if ((pageIndex > -1) && (pageSize > -1) && (shopId > -1)) {
			String awardName = HttpServletRequestUtil.getString(request,
					"awardName");
			Award awardCondition = compactAwardCondition4Search(shopId,
					awardName);
			AwardExecution ae = awardService.getAwardList(awardCondition,
					pageIndex, pageSize);
			modelMap.put("awardList", ae.getAwardList());
			modelMap.put("count", ae.getCount());
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
		}
		return modelMap;
	}

	private Award compactAwardCondition4Search(long shopId, String awardName) {
		Award awardCondition = new Award();
		awardCondition.setShopId(shopId);
		if (awardName != null) {
			awardCondition.setAwardName(awardName);
		}
		return awardCondition;
	}
}
