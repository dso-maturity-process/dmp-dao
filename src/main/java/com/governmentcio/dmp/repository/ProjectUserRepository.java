package com.governmentcio.dmp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.governmentcio.dmp.dao.ProjectUserDao;

public interface ProjectUserRepository
		extends PagingAndSortingRepository<ProjectUserDao, Long> {

}
