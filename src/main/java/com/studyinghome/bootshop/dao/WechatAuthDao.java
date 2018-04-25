package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.WechatAuth;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WechatAuthDao {
    WechatAuth queryWechatInfoByOpenId(String openId);

    int insertWechatAuth(WechatAuth wechatAuth);

    int deleteWechatAuth(Long wechatAuthId);
}
