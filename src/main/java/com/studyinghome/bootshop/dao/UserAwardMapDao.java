package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.UserAwardMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAwardMapDao {
    List<UserAwardMap> queryUserAwardMapList(
            @Param("userAwardCondition") UserAwardMap userAwardCondition,
            @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    int queryUserAwardMapCount(
            @Param("userAwardCondition") UserAwardMap userAwardCondition);

    UserAwardMap queryUserAwardMapById(long userAwardId);

    int insertUserAwardMap(UserAwardMap userAwardMap);

    int updateUserAwardMap(UserAwardMap userAwardMap);
}
