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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author <a href=mailto:support@governmentcio.com>support</a>
 *
 */
@Entity
@Table(name = "surveyresponse")
@JsonSerialize(using = SurveyResponseDaoSerializer.class)
public class SurveyResponseDao {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "surveytemplateid")
	private Long surveyTemplateId;

	@Column(name = "question")
	private String question;

	@Column(name = "answer")
	private String answer;

	/**
	 * Order or sequence in the survey.
	 */
	private Long sequence;

	@ManyToOne
	@JoinColumn(name = "surveyinstanceid", nullable = false)
	private SurveyResponseDao surveyResponseDao;

	/**
	 * 
	 */
	public SurveyResponseDao() {
		super();
	}

	/**
	 * @param id
	 * @param surveyTemplateId
	 * @param question
	 * @param answer
	 * @param sequence
	 */
	public SurveyResponseDao(Long id, Long surveyTemplateId, String question,
			String answer, Long sequence) {
		super();
		this.id = id;
		this.surveyTemplateId = surveyTemplateId;
		this.question = question;
		this.answer = answer;
		this.sequence = sequence;
	}

	/**
	 * @param surveyTemplateId
	 * @param question
	 * @param answer
	 * @param sequence
	 * @param surveyResponseDao
	 */
	public SurveyResponseDao(Long surveyTemplateId, String question,
			String answer, Long sequence, SurveyResponseDao surveyResponseDao) {
		super();
		this.surveyTemplateId = surveyTemplateId;
		this.question = question;
		this.answer = answer;
		this.sequence = sequence;
		this.surveyResponseDao = surveyResponseDao;
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
	 * @return the surveyResponseDao
	 */
	public SurveyResponseDao getSurveyResponseDao() {
		return surveyResponseDao;
	}

	/**
	 * @param surveyResponseDao the surveyResponseDao to set
	 */
	public void setSurveyResponseDao(SurveyResponseDao surveyResponseDao) {
		this.surveyResponseDao = surveyResponseDao;
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
		builder.append("SurveyResponseDao [id=").append(id)
				.append(", surveyTemplateId=").append(surveyTemplateId)
				.append(", question=").append(question).append(", answer=")
				.append(answer).append("]");
		return builder.toString();
	}

}
