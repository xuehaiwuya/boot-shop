package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.LocalAuthExecution;
import com.studyinghome.bootshop.entity.LocalAuth;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface LocalAuthService {
    /**
     * 通过用户名和密码进行验证
     *
     * @param userName
     * @return
     */
    LocalAuth getLocalAuthByUserNameAndPwd(String userName, String password);

    /**
     * 通过用户id获取用户验证信息
     *
     * @param userId
     * @return
     */
    LocalAuth getLocalAuthByUserId(long userId);

    /**
     * 添加本地用户
     *
     * @param localAuth
     * @param profileImg
     * @return
     * @throws RuntimeException
     */
    LocalAuthExecution register(LocalAuth localAuth,
                                CommonsMultipartFile profileImg) throws RuntimeException;

    /**
     * 绑定用户信息
     *
     * @param localAuth
     * @return
     * @throws RuntimeException
     */
    LocalAuthExecution bindLocalAuth(LocalAuth localAuth)
            throws RuntimeException;

    /**
     * 更新用户信息
     *
     * @param userName
     * @param password
     * @param newPassword
     * @return
     */
    LocalAuthExecution modifyLocalAuth(Long userId, String userName,
                                       String password, String newPassword);
}
