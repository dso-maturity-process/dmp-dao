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
@Table(name = "project")
@JsonSerialize(using = ProjectSerializer.class)
public class ProjectDao {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "projectDao", cascade = CascadeType.ALL)
	private Set<ProjectUserDao> projectUserDaos = new HashSet<ProjectUserDao>();

	/**
	 * @param userName
	 * @param password
	 */
	public ProjectDao() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param description
	 */
	public ProjectDao(final Long id, final String name,
			final String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/**
	 * @param name
	 * @param description
	 */
	public ProjectDao(final String name, final String description) {
		super();
		this.name = name;
		this.description = description;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
		ProjectDao other = (ProjectDao) obj;
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
		builder.append("ProjectDao [id=").append(id).append(", name=").append(name)
				.append(", description=").append(description).append("]");
		return builder.toString();
	}

}
