package com.governmentcio.dmp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.governmentcio.dmp.dao.RoleDao;

public interface RoleRepository extends PagingAndSortingRepository<RoleDao, Long> {
	/**
	 * Find by short name.
	 * 
	 * @param name RoleDao title
	 * @return {@link RoleDao} or null if none found.
	 */
	RoleDao findByType(@Param("title") String title);

	/**
	 * 
	 * Returns {@link RoleDao}s or null if none found. parameter.
	 */
	Page<RoleDao> findAll(Pageable pageRequest);

}
