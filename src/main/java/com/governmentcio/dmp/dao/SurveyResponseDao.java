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
 * @author <a href=mailto:support@governmentcio.com>support</a>
 *
 */
@Entity
@Table(name = "surveyresponse", uniqueConstraints = @UniqueConstraint(columnNames = {
		"SEQUENCE", "QUESTION" }))
@JsonSerialize(using = SurveyResponseDaoSerializer.class)
public class SurveyResponseDao {

	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Order or sequence in the survey.
	 */
	@Column(name = "SEQUENCE")
	private Long sequence;

	@Column(name = "QUESTION")
	private String question;

	@Column(name = "ANSWER")
	private String answer;

	@ManyToOne
	@JoinColumn(name = "surveyinstanceid", nullable = false)
	private SurveyInstanceDao surveyInstanceDao;

	/**
	 * 
	 */
	public SurveyResponseDao() {
		super();
	}

	/**
	 * @param id
	 * @param question
	 * @param answer
	 * @param sequence
	 */
	public SurveyResponseDao(Long id, String question, String answer,
			Long sequence) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.sequence = sequence;
	}

	/**
	 * 
	 * @param question
	 * @param answer
	 * @param sequence
	 * @param surveyInstanceDao
	 */
	public SurveyResponseDao(String question, String answer, Long sequence,
			SurveyInstanceDao surveyInstanceDao) {
		super();
		this.question = question;
		this.answer = answer;
		this.sequence = sequence;
		this.surveyInstanceDao = surveyInstanceDao;
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
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the sequence
	 */
	public Long getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return the surveyInstanceDao
	 */
	public SurveyInstanceDao getSurveyInstanceDao() {
		return surveyInstanceDao;
	}

	/**
	 * @param surveyInstanceDao the surveyInstanceDao to set
	 */
	public void setSurveyInstanceDao(SurveyInstanceDao surveyInstanceDao) {
		this.surveyInstanceDao = surveyInstanceDao;
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
		SurveyResponseDao other = (SurveyResponseDao) obj;
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
		builder.append("SurveyResponseDao [id=").append(id).append(", question=")
				.append(question).append(", answer=").append(answer).append("]");
		return builder.toString();
	}

}
