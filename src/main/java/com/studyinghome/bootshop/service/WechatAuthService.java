package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.WechatAuthExecution;
import com.studyinghome.bootshop.entity.WechatAuth;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface WechatAuthService {
    WechatAuth getWechatAuthByOpenId(String openId);

    WechatAuthExecution register(WechatAuth wechatAuth,
                                 CommonsMultipartFile profileImg) throws RuntimeException;

}
