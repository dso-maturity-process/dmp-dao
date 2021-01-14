/**
 * 
 */
package com.governmentcio.dmp.dao;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author <a href=mailto:support@governmentcio.com>support</a>
 *
 */
@Entity
@Table(name = "user")
@JsonSerialize(using = UserDaoSerializer.class)
public class UserDao {

	@OneToMany(mappedBy = "userDao", cascade = CascadeType.ALL)
	private Set<UserRoleDao> userRoleDaos = new HashSet<UserRoleDao>();

	@OneToMany(mappedBy = "userDao", cascade = CascadeType.ALL)
	private Set<ProjectUserDao> projectUserDaos = new HashSet<ProjectUserDao>();

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "firstName", unique = true)
	private String firstName;

	@Column(name = "lastName", unique = true)
	private String lastName;

	@Column(name = "userName", unique = true)
	private String userName;

	@Column(name = "password")
	private String password; // encrypted

	@Column(name = "createdTimestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	private Date createdTimestamp;

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 */
	public UserDao(String firstName, String lastName, String userName,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	/**
	 * 
	 * @param value
	 */
	public UserDao(final UserDao value) {
		super();
		this.id = value.id;
		this.firstName = value.firstName;
		this.lastName = value.lastName;
		this.password = value.password;
		this.userName = value.userName;
		this.createdTimestamp = value.createdTimestamp;
	}

	/**
	 * 
	 */
	public UserDao() {
		super();
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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the createdTimestamp
	 */
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	/**
	 * @return the userRoleDaos
	 */
	public Set<UserRoleDao> getUserRoleDaos() {
		return userRoleDaos;
	}

	public void addUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDaos.add(userRoleDao);
	}

	/**
	 * @param userRoleDaos the userRoleDaos to set
	 */
	public void setUserRoleDaos(Set<UserRoleDao> userRoleDaos) {
		this.userRoleDaos = userRoleDaos;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param createdTimestamp the createdTimestamp to set
	 */
	public void setCreatedTimestamp(Date created_at) {
		this.createdTimestamp = created_at;
	}

	/**
	 * @return the projectUserDaos
	 */
	public Set<ProjectUserDao> getProjectUserDaos() {
		return projectUserDaos;
	}

	/**
	 * @param projectUserDaos the projectUserDaos to set
	 */
	public void setProjectUserDaos(Set<ProjectUserDao> projectUserDaos) {
		this.projectUserDaos = projectUserDaos;
	}

	/**
	 * 
	 * @param projectUserDao
	 */
	public void addProjectUserDao(final ProjectUserDao projectUserDao) {
		this.projectUserDaos.add(projectUserDao);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDao other = (UserDao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDao [id=").append(id).append(", firstName=")
				.append(firstName).append(", lastName=").append(lastName)
				.append(", userName=").append(userName).append(", password=")
				.append(password).append(", createdTimestamp=").append(createdTimestamp)
				.append("]");
		return builder.toString();
	}
}
