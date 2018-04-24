package com.studyinghome.bootshop.service;

import com.studyinghome.bootshop.dto.AwardExecution;
import com.studyinghome.bootshop.entity.Award;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface AwardService {

	/**
	 * 
	 * @param awardCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	AwardExecution getAwardList(Award awardCondition, int pageIndex,
                                int pageSize);

	/**
	 * 
	 * @param awardId
	 * @return
	 */
	Award getAwardById(long awardId);

	/**
	 * 
	 * @param award
	 * @param thumbnail
	 * @return
	 */
	AwardExecution addAward(Award award, CommonsMultipartFile thumbnail);

	/**
	 * 
	 * @param award
	 * @param thumbnail
	 * @return
	 */
	AwardExecution modifyAward(Award award, CommonsMultipartFile thumbnail);

}
