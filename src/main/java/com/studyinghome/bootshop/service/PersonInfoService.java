package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.PersonInfoExecution;
import com.studyinghome.bootshop.entity.PersonInfo;

public interface PersonInfoService {

    /**
     * 通过用户id获取用户信息
     *
     * @param userId
     * @return
     */
    PersonInfo getPersonInfoById(Long userId);

    /**
     * 分页获取用户信息列表
     *
     * @param personInfoCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PersonInfoExecution getPersonInfoList(PersonInfo personInfoCondition,
                                          int pageIndex, int pageSize);

    /**
     * 添加用户
     *
     * @param personInfo
     * @return
     */
    PersonInfoExecution addPersonInfo(PersonInfo personInfo);

    /**
     * 更新用户信息
     *
     * @param personInfo
     * @return
     */
    PersonInfoExecution modifyPersonInfo(PersonInfo personInfo);

}
