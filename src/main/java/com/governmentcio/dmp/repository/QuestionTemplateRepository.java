package com.governmentcio.dmp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.governmentcio.dmp.dao.QuestionTemplateDao;

public interface QuestionTemplateRepository
		extends PagingAndSortingRepository<QuestionTemplateDao, Long> {

	/**
	 * 
	 * Returns {@link QuestionTemplateDao}s or null if none found. parameter.
	 */
	Page<QuestionTemplateDao> findAll(Pageable pageRequest);

}
