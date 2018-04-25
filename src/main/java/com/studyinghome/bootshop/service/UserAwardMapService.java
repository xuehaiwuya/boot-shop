package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.UserAwardMapExecution;
import com.studyinghome.bootshop.entity.UserAwardMap;

public interface UserAwardMapService {

	/**
	 * 分页获取用户奖品列表
	 * @param userAwardCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	UserAwardMapExecution listUserAwardMap(UserAwardMap userAwardCondition,
                                           Integer pageIndex, Integer pageSize);

	/**
	 * 通过id获取用户奖品
	 * @param userAwardMapId
	 * @return
	 */
	UserAwardMap getUserAwardMapById(long userAwardMapId);

	/**
	 * 兑换奖品
	 * @param userAwardMap
	 * @return
	 * @throws RuntimeException
	 */
	UserAwardMapExecution addUserAwardMap(UserAwardMap userAwardMap)
			throws RuntimeException;

	/**
	 * 更新奖品信息
	 * @param userAwardMap
	 * @return
	 * @throws RuntimeException
	 */
	UserAwardMapExecution modifyUserAwardMap(UserAwardMap userAwardMap)
			throws RuntimeException;

}
