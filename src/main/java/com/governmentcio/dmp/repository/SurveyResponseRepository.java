package com.governmentcio.dmp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.governmentcio.dmp.dao.SurveyResponseDao;

public interface SurveyResponseRepository
		extends PagingAndSortingRepository<SurveyResponseDao, Long> {
}
