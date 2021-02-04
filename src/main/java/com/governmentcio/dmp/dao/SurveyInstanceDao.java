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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author <a href=mailto:support@governmentcio.com>support</a>
 *
 */
@Entity
@Table(name = "surveyinstance", uniqueConstraints = @UniqueConstraint(columnNames = {
		"USERID", "ROLEID", "PROJECTID" }))
@JsonSerialize(using = SurveyInstanceDaoSerializer.class)
public class SurveyInstanceDao {

	@Id
	@GeneratedValue
	@Column(name = "SURVEYINSTANCEID")
	private Long id;

	@Column(name = "SURVERYTEMPLATEID")
	private Long surveyTemplateId;

	@Column(name = "PROJECTID")
	private Long projectId;

	@Column(name = "USERID")
	private Long userid;

	@Column(name = "ROLEID")
	private Long roleid;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "surveyInstanceDao")
	private Set<
			SurveyResponseDao> surveyResponseDaos = new HashSet<SurveyResponseDao>();

	@Column(name = "starttimestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	private Date startTimestamp;

	/**
	 * 
	 */
	public SurveyInstanceDao() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param surveyTemplateId
	 * @param projectId
	 * @param userid
	 * @param roleid
	 * @param name
	 * @param description
	 * @param surveyResponseDaos
	 */
	public SurveyInstanceDao(Long id, Long surveyTemplateId, Long projectId,
			Long userid, Long roleid, String name, String description,
			Set<SurveyResponseDao> surveyResponseDaos) {
		super();
		this.id = id;
		this.surveyTemplateId = surveyTemplateId;
		this.projectId = projectId;
		this.userid = userid;
		this.roleid = roleid;
		this.name = name;
		this.description = description;
		this.surveyResponseDaos = surveyResponseDaos;
	}

	/**
	 * 
	 * @param surveyTemplateId
	 * @param projectId
	 * @param userid
	 * @param roleid
	 * @param name
	 */
	public SurveyInstanceDao(Long surveyTemplateId, Long projectId, Long userid,
			Long roleid, String name) {
		super();
		this.surveyTemplateId = surveyTemplateId;
		this.projectId = projectId;
		this.userid = userid;
		this.roleid = roleid;
		this.name = name;
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
	 * @return the surveyTemplateId
	 */
	public Long getSurveyTemplateId() {
		return surveyTemplateId;
	}

	/**
	 * @param surveyTemplateId the surveyTemplateId to set
	 */
	public void setSurveyTemplateId(Long surveyTemplateId) {
		this.surveyTemplateId = surveyTemplateId;
	}

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the userid
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	/**
	 * @return the roleid
	 */
	public Long getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid the roleid to set
	 */
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
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
	 * @return the surveyResponseDaos
	 */
	public Set<SurveyResponseDao> getSurveyResponseDaos() {
		return surveyResponseDaos;
	}

	/**
	 * @param surveyResponseDaos the surveyResponseDaos to set
	 */
	public void setSurveyResponseDaos(Set<SurveyResponseDao> surveyResponseDaos) {
		this.surveyResponseDaos = surveyResponseDaos;
	}

	/**
	 * @return the startTimestamp
	 */
	public Date getStartTimestamp() {
		return startTimestamp;
	}

	/**
	 * @param startTimestamp the startTimestamp to set
	 */
	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
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
		SurveyInstanceDao other = (SurveyInstanceDao) obj;
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
		builder.append("SurveyInstanceDao [id=").append(id)
				.append(", surveyTemplateId=").append(surveyTemplateId)
				.append(", projectId=").append(projectId).append(", userid=")
				.append(userid).append(", roleid=").append(roleid).append(", name=")
				.append(name).append(", description=").append(description)
				.append(", startTimestamp=").append(startTimestamp).append("]");
		return builder.toString();
	}

}
