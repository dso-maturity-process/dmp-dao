package com.governmentcio.dmp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.governmentcio.dmp.dao.SurveyTemplateQuestionTemplateDao;

public interface SurveyTemplateQuestionTemplateRepository
		extends PagingAndSortingRepository<SurveyTemplateQuestionTemplateDao, Long> {

	/**
	 * 
	 * Returns {@link SurveyTemplateQuestionTemplateDao}s or null if none found.
	 * parameter.
	 */
	Page<SurveyTemplateQuestionTemplateDao> findAll(Pageable pageRequest);

}
