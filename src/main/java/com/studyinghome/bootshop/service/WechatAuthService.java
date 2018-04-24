package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.WechatAuthExecution;
import com.studyinghome.bootshop.entity.WechatAuth;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface WechatAuthService {

	/**
	 * 
	 * @param openId
	 * @return
	 */
	WechatAuth getWechatAuthByOpenId(String openId);

	/**
	 * 
	 * @param wechatAuth
	 * @param profileImg
	 * @return
	 * @throws RuntimeException
	 */
	WechatAuthExecution register(WechatAuth wechatAuth,
                                 CommonsMultipartFile profileImg) throws RuntimeException;

}
