package com.studyinghome.bootshop.dao;

import com.studyinghome.bootshop.entity.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaDao {
	List<Area> queryArea();

	int insertArea(Area area);

	int updateArea(Area area);

	int deleteArea(long areaId);

	int batchDeleteArea(List<Long> areaIdList);
}
