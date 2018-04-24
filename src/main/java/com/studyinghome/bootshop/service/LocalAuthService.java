package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.LocalAuthExecution;
import com.studyinghome.bootshop.entity.LocalAuth;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface LocalAuthService {
	/**
	 * 
	 * @param userName
	 * @return
	 */
	LocalAuth getLocalAuthByUserNameAndPwd(String userName, String password);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	LocalAuth getLocalAuthByUserId(long userId);

	/**
	 * 
	 * @param localAuth
	 * @param profileImg
	 * @return
	 * @throws RuntimeException
	 */
	LocalAuthExecution register(LocalAuth localAuth,
                                CommonsMultipartFile profileImg) throws RuntimeException;

	/**
	 *
	 * @param localAuth
	 * @return
	 * @throws RuntimeException
	 */
	LocalAuthExecution bindLocalAuth(LocalAuth localAuth)
			throws RuntimeException;

	/**
	 *
	 * @param userName
	 * @param password
	 * @param newPassword
	 * @return
	 */
	LocalAuthExecution modifyLocalAuth(Long userId, String userName,
                                       String password, String newPassword);
}
