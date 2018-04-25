package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.AwardExecution;
import com.studyinghome.bootshop.entity.Award;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface AwardService {

    /**
     * 分页获取奖品列表
     *
     * @param awardCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    AwardExecution getAwardList(Award awardCondition, int pageIndex,
                                int pageSize);

    /**
     * 通过奖品id获取奖品
     *
     * @param awardId
     * @return
     */
    Award getAwardById(long awardId);

    /**
     * 添加奖品
     *
     * @param award
     * @param thumbnail
     * @return
     */
    AwardExecution addAward(Award award, CommonsMultipartFile thumbnail);

    /**
     * 更新奖品信息
     *
     * @param award
     * @param thumbnail
     * @return
     */
    AwardExecution modifyAward(Award award, CommonsMultipartFile thumbnail);

}
