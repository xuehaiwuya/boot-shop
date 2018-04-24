package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.LocalAuth;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface LocalAuthDao {

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	LocalAuth queryLocalByUserNameAndPwd(@Param("userName") String userName,
                                         @Param("password") String password);

	/**
	 *
	 * @param userId
	 * @return
	 */
	LocalAuth queryLocalByUserId(@Param("userId") long userId);

	/**
	 *
	 * @param localAuth
	 * @return
	 */
	int insertLocalAuth(LocalAuth localAuth);

	/**
	 *
	 * @param localAuth
	 * @return
	 */
	int updateLocalAuth(@Param("userId") Long userId,
                        @Param("userName") String userName,
                        @Param("password") String password,
                        @Param("newPassword") String newPassword,
                        @Param("lastEditTime") Date lastEditTime);
}
