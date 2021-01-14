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
@Table(name = "question_template")
@JsonSerialize(using = QuestionTemplateDaoSerializer.class)
public class QuestionTemplateDao {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "text")
	private String text;

	@OneToMany(mappedBy = "questionTemplateDao", cascade = CascadeType.ALL)
	private Set<
			SurveyTemplateQuestionTemplateDao> surveyTemplateQuestionTemplateDaos = new HashSet<
					SurveyTemplateQuestionTemplateDao>();

	/**
	 * 
	 */
	public QuestionTemplateDao() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param text
	 */
	public QuestionTemplateDao(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	/**
	 * 
	 * @param text
	 */
	public QuestionTemplateDao(final String text) {
		super();
		this.text = text;
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the surveyTemplateQuestionTemplateDaos
	 */
	public Set<
			SurveyTemplateQuestionTemplateDao> getSurveyTemplateQuestionDaos() {
		return surveyTemplateQuestionTemplateDaos;
	}

	/**
	 * @param surveyTemplateQuestionTemplateDaos the
	 *                                           surveyTemplateQuestionTemplateDaos
	 *                                           to set
	 */
	public void setSurveyTemplateQuestionDaos(Set<
			SurveyTemplateQuestionTemplateDao> surveyTemplateQuestionTemplateDaos) {
		this.surveyTemplateQuestionTemplateDaos = surveyTemplateQuestionTemplateDaos;
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
		QuestionTemplateDao other = (QuestionTemplateDao) obj;
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
		builder.append("QuestionTemplateDao [id=").append(id).append(", text=")
				.append(text).append("]");
		return builder.toString();
	}

}
