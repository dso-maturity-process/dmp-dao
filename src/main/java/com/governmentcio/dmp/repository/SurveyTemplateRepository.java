package com.governmentcio.dmp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.governmentcio.dmp.dao.SurveyTemplateDao;

public interface SurveyTemplateRepository
		extends PagingAndSortingRepository<SurveyTemplateDao, Long> {

	SurveyTemplateDao findByName(String name);

	/**
	 * 
	 * Returns {@link SurveyTemplateDao}s or null if none found. parameter.
	 */
	Page<SurveyTemplateDao> findAll(Pageable pageRequest);

}
