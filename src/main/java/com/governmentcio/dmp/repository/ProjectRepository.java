package com.governmentcio.dmp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.governmentcio.dmp.dao.ProjectDao;

public interface ProjectRepository
		extends PagingAndSortingRepository<ProjectDao, Long> {

	/**
	 * Find by project name.
	 * 
	 * @param name ProjectDao name
	 * @return {@link ProjectDao} or null if none found.
	 */
	ProjectDao findByName(@Param("name") String name);

}
