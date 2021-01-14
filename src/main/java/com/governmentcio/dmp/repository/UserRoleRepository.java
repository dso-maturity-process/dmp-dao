/**
 * 
 */
package com.governmentcio.dmp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.governmentcio.dmp.dao.UserRoleDao;

/**
 * @author <a href=mailto:support@governmentcio.com>support
 *
 */
public interface UserRoleRepository extends PagingAndSortingRepository<UserRoleDao, Long> {

	/**
	 * 
	 * @return {@link UserRoleDao}s or null if none found. parameter.
	 */
	Page<UserRoleDao> findAll(Pageable pageRequest);

}
