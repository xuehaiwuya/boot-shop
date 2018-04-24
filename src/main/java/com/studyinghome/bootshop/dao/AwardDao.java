package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.Award;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AwardDao {
	List<Award> queryAwardList(@Param("awardCondition") Award awardCondition,
                               @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

	int queryAwardCount(@Param("awardCondition") Award awardCondition);

	Award queryAwardByAwardId(long awardId);

	int insertAward(Award award);

	int updateAward(Award award);

	int deleteAward(long awardId);
}
