package com.governmentcio.dmp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.governmentcio.dmp.dao.UserDao;

public interface UserRepository extends PagingAndSortingRepository<UserDao, Long> {
	/**
	 * Find by user name.
	 * 
	 * @param name UserDao name
	 * @return {@link UserDao} or null if none found.
	 */
	UserDao findByuserName(@Param("userName") String userName);

	/**
	 * 
	 * Returns {@link UserDao}s or null if none found. parameter.
	 */
	Page<UserDao> findAll(Pageable pageRequest);
	
	UserDao getOne(Long id);

}
