package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.UserShopMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserShopMapDao {
    List<UserShopMap> queryUserShopMapList(
            @Param("userShopCondition") UserShopMap userShopCondition,
            @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    UserShopMap queryUserShopMap(@Param("userId") long userId,
                                 @Param("shopId") long shopId);

    int queryUserShopMapCount(
            @Param("userShopCondition") UserShopMap userShopCondition);

    int insertUserShopMap(UserShopMap userShopMap);

    int updateUserShopMapPoint(UserShopMap userShopMap);

}
