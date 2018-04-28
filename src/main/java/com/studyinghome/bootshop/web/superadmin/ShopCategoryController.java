package com.studyinghome.bootshop.web.superadmin;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studyinghome.bootshop.dto.Result;
import com.studyinghome.bootshop.dto.ShopCategoryExecution;
import com.studyinghome.bootshop.entity.ConstantForSuperAdmin;
import com.studyinghome.bootshop.entity.ShopCategory;
import com.studyinghome.bootshop.enums.ShopCategoryStateEnum;
import com.studyinghome.bootshop.service.ShopCategoryService;
import com.studyinghome.bootshop.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class ShopCategoryController {
	@Autowired
	private ShopCategoryService shopCategoryService;

	@PostMapping("/listshopcategorys")
	private Map<String, Object> listShopCategorys() {
		Map<String, Object> modelMap = new HashMap<>();
		try {
            List<ShopCategory> list = shopCategoryService.getShopCategoryList(null);
			modelMap.put(ConstantForSuperAdmin.PAGE_SIZE, list);
			modelMap.put(ConstantForSuperAdmin.TOTAL, list.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		return modelMap;
	}

	@PostMapping("/list1stlevelshopcategorys")
	private Result<List<ShopCategory>> list1stLevelShopCategorys() {
		List<ShopCategory> list = new ArrayList<>();
		try {
			list = shopCategoryService.getFirstLevelShopCategoryList();
		} catch (Exception e) {
			e.printStackTrace();
			ShopCategoryStateEnum a = ShopCategoryStateEnum.INNER_ERROR;
			return new Result<>(false, a.getState(),a.getStateInfo());
		}
		return new Result<>(true, list);
	}

	@PostMapping("/addshopcategory")
	private Map<String, Object> addShopCategory(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		ShopCategory shopCategory = null;
		String shopCategoryStr = HttpServletRequestUtil.getString(request,"shopCategoryStr");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile thumbnail = (CommonsMultipartFile) multipartRequest
				.getFile("shopCategoryManagementAdd_shopCategoryImg");
		try {
			shopCategory = mapper.readValue(shopCategoryStr, ShopCategory.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}
		if (shopCategory != null && thumbnail != null) {
			try {
				// decode可能有中文的地方
				shopCategory.setShopCategoryName((shopCategory.getShopCategoryName() == null) ? null : (
				        URLDecoder.decode(shopCategory.getShopCategoryName(), "UTF-8")));
				shopCategory.setShopCategoryDesc((shopCategory
						.getShopCategoryDesc() == null) ? null : (URLDecoder
						.decode(shopCategory.getShopCategoryDesc(), "UTF-8")));
				ShopCategoryExecution ae = shopCategoryService.addShopCategory(shopCategory, thumbnail);
				if (ae.getState() == ShopCategoryStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", ae.getStateInfo());
				}
			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入店铺类别信息");
		}
		return modelMap;
	}

	@PostMapping("/modifyshopcategory")
	private Map<String, Object> modifyShopCategory(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		ShopCategory shopCategory = null;
		String shopCategoryStr = HttpServletRequestUtil.getString(request,"shopCategoryStr");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile thumbnail = (CommonsMultipartFile) multipartRequest
				.getFile("shopCategoryManagementEdit_shopCategoryImg");
		try {
			shopCategory = mapper.readValue(shopCategoryStr, ShopCategory.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}
		if (shopCategory != null && shopCategory.getShopCategoryId() != null) {
			try {
				boolean thumbnailChange = HttpServletRequestUtil.getBoolean(request, "thumbnailChange");
				// decode可能有中文的地方
				shopCategory.setShopCategoryName((shopCategory
						.getShopCategoryName() == null) ? null : (URLDecoder
						.decode(shopCategory.getShopCategoryName(), "UTF-8")));
				shopCategory.setShopCategoryDesc((shopCategory
						.getShopCategoryDesc() == null) ? null : (URLDecoder
						.decode(shopCategory.getShopCategoryDesc(), "UTF-8")));
				ShopCategoryExecution ae = shopCategoryService
						.modifyShopCategory(shopCategory, thumbnail,thumbnailChange);
				if (ae.getState() == ShopCategoryStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", ae.getStateInfo());
				}
			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入店铺类别信息");
		}
		return modelMap;
	}

	@PostMapping("/removeshopcategory")
	private Map<String, Object> removeShopCategory(Long shopCategoryId) {
		Map<String, Object> modelMap = new HashMap<>();
		if (shopCategoryId != null && shopCategoryId > 0) {
			try {
				ShopCategoryExecution ae = shopCategoryService.removeShopCategory(shopCategoryId);
				if (ae.getState() == ShopCategoryStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", ae.getStateInfo());
				}
			} catch (RuntimeException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入店铺类别信息");
		}
		return modelMap;
	}

	@PostMapping("/removeshopcategories")
	private Map<String, Object> removeShopCategories(
			String shopCategoryIdListStr) {
		Map<String, Object> modelMap = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Long.class);
		List<Long> shopCategoryIdList = null;
		try {
			shopCategoryIdList = mapper.readValue(shopCategoryIdListStr,javaType);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		if (shopCategoryIdList != null && shopCategoryIdList.size() > 0) {
			try {
				ShopCategoryExecution ae = shopCategoryService.removeShopCategoryList(shopCategoryIdList);
				if (ae.getState() == ShopCategoryStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", ae.getStateInfo());
				}
			} catch (RuntimeException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入店铺类别信息");
		}
		return modelMap;
	}
}
