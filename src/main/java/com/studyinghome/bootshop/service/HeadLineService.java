package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.HeadLineExecution;
import com.studyinghome.bootshop.entity.HeadLine;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.List;

public interface HeadLineService {

    /**
     * 获取头条列表
     *
     * @param headLineCondition
     * @return
     * @throws IOException
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition)
            throws IOException;

    /**
     * 添加头条
     *
     * @param headLine
     * @param thumbnail
     * @return
     */
    HeadLineExecution addHeadLine(HeadLine headLine,
                                  CommonsMultipartFile thumbnail);

    /**
     * 更新头条内容
     *
     * @param headLine
     * @param thumbnail
     * @return
     */
    HeadLineExecution modifyHeadLine(HeadLine headLine,
                                     CommonsMultipartFile thumbnail);

    /**
     * 通过id删除头条
     *
     * @param headLineId
     * @return
     */
    HeadLineExecution removeHeadLine(long headLineId);

    /**
     * id批量删除头条内容
     *
     * @param headLineIdList
     * @return
     */
    HeadLineExecution removeHeadLineList(List<Long> headLineIdList);

}
