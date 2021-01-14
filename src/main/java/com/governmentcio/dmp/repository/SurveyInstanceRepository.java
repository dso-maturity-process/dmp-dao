package com.governmentcio.dmp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.governmentcio.dmp.dao.SurveyInstanceDao;

public interface SurveyInstanceRepository
		extends PagingAndSortingRepository<SurveyInstanceDao, Long> {

	/**
	 * Find by name.
	 * 
	 * @param name SurveyInstanceDao name
	 * @return {@link SurveyInstanceDao} or null if none found.
	 */
	SurveyInstanceDao findByName(@Param("name") String name);

}
