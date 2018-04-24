package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.UserProductMapExecution;
import com.studyinghome.bootshop.entity.UserProductMap;

public interface UserProductMapService {
	/**
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	UserProductMapExecution listUserProductMap(
            UserProductMap userProductCondition, Integer pageIndex,
            Integer pageSize);

	/**
	 * 
	 * @param userProductMap
	 * @return
	 * @throws RuntimeException
	 */
	UserProductMapExecution addUserProductMap(UserProductMap userProductMap)
			throws RuntimeException;

}
