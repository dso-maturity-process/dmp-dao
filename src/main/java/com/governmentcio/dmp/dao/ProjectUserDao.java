/**
 * 
 */
package com.governmentcio.dmp.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author <a href=mailto:support@governmentcio.com>support
 *
 */
@Entity
@Table(name = "project_user", uniqueConstraints = @UniqueConstraint(columnNames = {
		"USER_ID", "PROJECT_ID" }))
@JsonSerialize(using = ProjectUserDaoSerializer.class)
public class ProjectUserDao {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserDao userDao;

	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private ProjectDao projectDao;

	/**
	 * 
	 */
	public ProjectUserDao() {
		super();
	}

	/**
	 * 
	 * @param projectDao
	 * @param userDao
	 */
	public ProjectUserDao(final ProjectDao projectDao, final UserDao userDao) {
		this.projectDao = projectDao;
		this.userDao = userDao;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUser(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @return the projectDao
	 */
	public ProjectDao getProjectDao() {
		return projectDao;
	}

	/**
	 * @param projectDao the projectDao to set
	 */
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
