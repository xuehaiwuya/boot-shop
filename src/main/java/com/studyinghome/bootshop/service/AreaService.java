package com.studyinghome.bootshop.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.studyinghome.bootshop.dto.AreaExecution;
import com.studyinghome.bootshop.entity.Area;

import java.io.IOException;
import java.util.List;

public interface AreaService {
    /**
     * 获取地域列表
     *
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    List<Area> getAreaList() throws JsonParseException, JsonMappingException,
            IOException;

    /**
     * 添加地域
     *
     * @param area
     * @return
     */
    AreaExecution addArea(Area area);

    /**
     * 更新地域信息
     *
     * @param area
     * @return
     */
    AreaExecution modifyArea(Area area);

    /**
     * 通过id删除指定地域
     *
     * @param areaId
     * @return
     */
    AreaExecution removeArea(long areaId);

    /**
     * id批量删除地域
     *
     * @param areaIdList
     * @return
     */
    AreaExecution removeAreaList(List<Long> areaIdList);

}
