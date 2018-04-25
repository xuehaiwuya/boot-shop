package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.UserProductMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserProductMapDao {
    List<UserProductMap> queryUserProductMapList(
            @Param("userProductCondition") UserProductMap userProductCondition,
            @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    int queryUserProductMapCount(
            @Param("userProductCondition") UserProductMap userProductCondition);

    int insertUserProductMap(UserProductMap userProductMap);
}
