package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.HeadLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HeadLineDao {

    List<HeadLine> queryHeadLine(
            @Param("headLineCondition") HeadLine headLineCondition);

    HeadLine queryHeadLineById(long lineId);

    List<HeadLine> queryHeadLineByIds(List<Long> lineIdList);

    int insertHeadLine(HeadLine headLine);

    int updateHeadLine(HeadLine headLine);

    int deleteHeadLine(long headLineId);

    int batchDeleteHeadLine(List<Long> lineIdList);
}
