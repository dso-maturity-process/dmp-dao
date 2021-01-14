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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author <a href=mailto:support@governmentcio.com>support
 *
 */
@Entity
@Table(name = "surveytemplate_questiontemplate")
@JsonSerialize(using = SurveyTemplateQuestionTemplateDaoSerializer.class)
public class SurveyTemplateQuestionTemplateDao {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "surveytemplate_ID")
	private SurveyTemplateDao surveyTemplateDao;

	@ManyToOne
	@JoinColumn(name = "question_ID")
	private QuestionTemplateDao questionTemplateDao;

	/**
	 * Order or sequence in the survey.
	 */
	private Long sequence;

	/**
	 * 
	 */
	public SurveyTemplateQuestionTemplateDao() {
		super();
	}

	/**
	 * 
	 * @param userDao
	 * @param roleDao
	 */
	public SurveyTemplateQuestionTemplateDao(final SurveyTemplateDao surveyTemplateDao,
			final QuestionTemplateDao questionTemplateDao) {
		this.surveyTemplateDao = surveyTemplateDao;
		this.questionTemplateDao = questionTemplateDao;
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
	 * @return the surveyTemplateDao
	 */
	public SurveyTemplateDao getSurveyTemplateDao() {
		return surveyTemplateDao;
	}

	/**
	 * @param surveyTemplateDao the surveyTemplateDao to set
	 */
	public void setSurveyTemplateDao(SurveyTemplateDao surveyTemplateDao) {
		this.surveyTemplateDao = surveyTemplateDao;
	}

	/**
	 * @return the questionTemplateDao
	 */
	public QuestionTemplateDao getQuestionDao() {
		return questionTemplateDao;
	}

	/**
	 * @param questionTemplateDao the questionTemplateDao to set
	 */
	public void setQuestionDao(QuestionTemplateDao questionTemplateDao) {
		this.questionTemplateDao = questionTemplateDao;
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
	public void setSequence(Long order) {
		this.sequence = order;
	}

}
