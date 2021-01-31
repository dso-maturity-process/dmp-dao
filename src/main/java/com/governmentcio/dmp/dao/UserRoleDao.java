/**
 * 
 */
package com.governmentcio.dmp.dao;

import javax.persistence.Column;
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
@Table(name = "user_role", uniqueConstraints = @UniqueConstraint(columnNames = {
		"USER_ID", "ROLE_ID", "PROJECTID" }))
@JsonSerialize(using = UserRoleDaoSerializer.class)
public class UserRoleDao {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserDao userDao;

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private RoleDao roleDao;

	@Column(name = "PROJECTID")
	private Long projectID;

	/**
	 * 
	 */
	public UserRoleDao() {
		super();
	}

	/**
	 * 
	 * @param userDao
	 * @param roleDao
	 */
	public UserRoleDao(final UserDao userDao, final RoleDao roleDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
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

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRole(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * @return the projectID
	 */
	public Long getProjectID() {
		return projectID;
	}

	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}
}
