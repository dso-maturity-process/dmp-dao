/**
 * 
 */
package com.governmentcio.dmp.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author <a href=mailto:support@governmentcio.com>support</a>
 *
 */
@Entity
@Table(name = "role")
@JsonSerialize(using = RoleDaoSerializer.class)
public class RoleDao {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "roletype")
	private String type;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "roleDao", cascade = CascadeType.ALL)
	private Set<UserRoleDao> userRoleDaos = new HashSet<UserRoleDao>();

	/**
	 * 
	 * @param id
	 * @param type
	 * @param name
	 * @param description
	 */
	public RoleDao(Long id, String type, String name, String description) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
	}

	/**
	 * 
	 * @param type
	 * @param name
	 * @param description
	 */
	public RoleDao(String type, String name, String description) {
		super();
		this.type = type;
		this.name = name;
		this.description = description;
	}

	/**
	 * 
	 */
	public RoleDao() {
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Set<UserRoleDao> getUserRoleDaos() {
		return userRoleDaos;
	}

	public void setUserRoles(Set<UserRoleDao> userRoleDaos) {
		this.userRoleDaos = userRoleDaos;
	}

	public void addUserRole(UserRoleDao userRoleDao) {
		this.userRoleDaos.add(userRoleDao);
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
		RoleDao other = (RoleDao) obj;
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
		builder.append("RoleDao [id=").append(id).append(", title=")
				.append(", description=").append(description).append("]");
		return builder.toString();
	}

}
