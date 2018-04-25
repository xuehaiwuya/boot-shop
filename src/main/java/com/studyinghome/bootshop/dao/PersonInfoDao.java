package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.PersonInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonInfoDao {

    List<PersonInfo> queryPersonInfoList(
            @Param("personInfoCondition") PersonInfo personInfoCondition,
            @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    int queryPersonInfoCount(
            @Param("personInfoCondition") PersonInfo personInfoCondition);

    PersonInfo queryPersonInfoById(long userId);

    int insertPersonInfo(PersonInfo personInfo);

    int updatePersonInfo(PersonInfo personInfo);

    int deletePersonInfo(long userId);
}
