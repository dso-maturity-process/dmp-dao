/**
 * 
 */
package com.governmentcio.dmp.dao;

import java.util.Set;

import com.governmentcio.dmp.model.Project;
import com.governmentcio.dmp.model.QuestionTemplate;
import com.governmentcio.dmp.model.Role;
import com.governmentcio.dmp.model.Role.RoleType;
import com.governmentcio.dmp.model.SurveyInstance;
import com.governmentcio.dmp.model.SurveyResponse;
import com.governmentcio.dmp.model.SurveyTemplate;
import com.governmentcio.dmp.model.User;

/**
 * 
 * @author William Drew
 * @version 1.0
 * @since 1.0
 * @see
 */
public final class DomainFactory {

	/**
	 * 
	 */
	private DomainFactory() {
	}

	/**
	 * @param userDao
	 * @return
	 */
	public static User createUser(UserDao userDao) {

		User user = null;

		if (null != userDao) {

			user = new User(userDao.getId(), userDao.getFirstName(),
					userDao.getLastName(), userDao.getUserName(), userDao.getPassword());

			user.setCreatedTimestamp(userDao.getCreatedTimestamp());

			Set<UserRoleDao> userRoleDaos = userDao.getUserRoleDaos();

			for (UserRoleDao urdao : userRoleDaos) {
				if (null != urdao) {
					RoleDao roleDao = urdao.getRoleDao();
					if (null != roleDao) {

						String typeAsString = roleDao.getType();
						Role.RoleType rt = RoleType.valueOf(roleDao.getType());

						Role role = new Role(roleDao.getId(), rt, typeAsString);
						user.getRoles().add(role);
					}
				}
			}
		}

		return user;
	}

	/**
	 * @param user
	 * @return
	 */
	public static UserDao createUserDao(User user) {

		UserDao userDao = null;

		if (null != user) {

			userDao = new UserDao(user.getFirstName(), user.getLastName(),
					user.getUserName(), user.getPassword());

			userDao.setId(Long.valueOf(user.getId()));

			Set<Role> roles = user.getRoles();

			for (Role role : roles) {
				if (null != role) {
					RoleDao roleDao = new RoleDao(Long.valueOf(role.getId()),
							role.getRoleType().name(), role.getName(), role.getDescription());

					UserRoleDao userRoleDao = new UserRoleDao(userDao, roleDao);

					userDao.addUserRoleDao(userRoleDao);

				}
			}
		}

		return userDao;
	}

	/**
	 * @param roleDao
	 * @return
	 */
	public static Role createRole(RoleDao roleDao) {

		Role role = null;

		try {
			if (null != roleDao) {
				String typeAsString = roleDao.getType();
				RoleType rt = RoleType.valueOf(typeAsString);
				role = new Role(roleDao.getId(), rt, typeAsString);

				role.setDescription(roleDao.getDescription());

				Set<UserRoleDao> userRoleDaos = roleDao.getUserRoleDaos();

				for (UserRoleDao urdao : userRoleDaos) {
					if (null != urdao) {
						UserDao userDao = urdao.getUserDao();
						if (null != userDao) {
							User user = new User(userDao.getId(), userDao.getFirstName(),
									userDao.getLastName(), userDao.getUserName(),
									userDao.getPassword());

							role.getUsers().add(user);
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return role;
	}

	/**
	 * @param surveyTemplateDao
	 * @return
	 */
	public static SurveyTemplate createSurveyTemplate(
			SurveyTemplateDao surveyTemplateDao) {

		SurveyTemplate surveyTemplate = null;

		if (null != surveyTemplateDao) {

			surveyTemplate = new SurveyTemplate(surveyTemplateDao.getId(),
					surveyTemplateDao.getName());

			surveyTemplate.setDescription(surveyTemplateDao.getDescription());

			Set<SurveyTemplateQuestionTemplateDao> surveyTemplateQuestionTemplateDaos = surveyTemplateDao
					.getSurveyTemplateQuestionTemplateDaos();

			for (SurveyTemplateQuestionTemplateDao surveyTemplateQuestionTemplateDao : surveyTemplateQuestionTemplateDaos) {
				if (null != surveyTemplateQuestionTemplateDao) {
					QuestionTemplateDao questionTemplateDao = surveyTemplateQuestionTemplateDao
							.getQuestionDao();
					if (null != questionTemplateDao) {

						QuestionTemplate questionTemplate = new QuestionTemplate(
								questionTemplateDao.getId(), questionTemplateDao.getText());
						questionTemplate
								.setSequence(surveyTemplateQuestionTemplateDao.getSequence());
						surveyTemplate.getQuestionTemplates().add(questionTemplate);
					}
				}
			}
		}

		return surveyTemplate;
	}

	/**
	 * @param SurveyInstanceDao
	 * @return
	 */
	public static SurveyInstance createSurveyInstance(
			SurveyInstanceDao surveyInstanceDao) {

		SurveyInstance surveyInstance = null;

		if (null != surveyInstanceDao) {

			surveyInstance = new SurveyInstance(surveyInstanceDao.getId(),
					surveyInstanceDao.getSurveyTemplateId(),
					surveyInstanceDao.getProjectId(), surveyInstanceDao.getName());

			surveyInstance.setStartTimestamp(surveyInstanceDao.getStartTimestamp());
			surveyInstance.setDescription(surveyInstanceDao.getDescription());

			Set<SurveyResponseDao> surveyResponseDaos = surveyInstanceDao
					.getSurveyResponseDaos();

			for (SurveyResponseDao surveyResponseDao : surveyResponseDaos) {

				if (null != surveyResponseDao) {

					SurveyResponse surveyResponse = new SurveyResponse(
							surveyResponseDao.getId(), surveyResponseDao.getQuestion());

					surveyResponse
							.setSurveyinstanceid(surveyResponseDao.getSurveyTemplateId());
					surveyResponse.setAnswer(surveyResponseDao.getAnswer());
					surveyResponse.setSequence(surveyResponseDao.getSequence());

					surveyInstance.getSurveyresponses().add(surveyResponse);
				}
			}
		}

		return surveyInstance;

	}

	/**
	 * 
	 * @param questionTemplateDao
	 * @return
	 */
	public static QuestionTemplate createQuestionTemplate(
			QuestionTemplateDao questionTemplateDao) {

		QuestionTemplate questionTemplate = null;

		if (null != questionTemplateDao) {

			questionTemplate = new QuestionTemplate(questionTemplateDao.getId(),
					questionTemplateDao.getText());

			Set<SurveyTemplateQuestionTemplateDao> surveyTemplateQuestionTemplateDaos = questionTemplateDao
					.getSurveyTemplateQuestionTemplateDaos();

			for (SurveyTemplateQuestionTemplateDao surveyTemplateQuestionTemplateDao : surveyTemplateQuestionTemplateDaos) {

				if (null != surveyTemplateQuestionTemplateDao) {
					SurveyTemplateDao surveyTemplateDao = surveyTemplateQuestionTemplateDao
							.getSurveyTemplateDao();

					if (null != surveyTemplateDao) {

						SurveyTemplate surveyTemplate = new SurveyTemplate(
								surveyTemplateDao.getId(), surveyTemplateDao.getName());

						if ((null != surveyTemplateDao.getDescription())
								&& (!surveyTemplateDao.getDescription().isEmpty())) {
							surveyTemplate.setDescription(surveyTemplateDao.getDescription());
						}
						questionTemplate.getSurveyTemplates().add(surveyTemplate);
					}
				}
			}
		}

		return questionTemplate;
	}

	/**
	 * 
	 * @param projectDao
	 * @return
	 */
	public static Project createProject(ProjectDao projectDao) {

		Project project = null;

		if (null != projectDao) {

			project = new Project(projectDao.getId(), projectDao.getName());

			project.setDescription(projectDao.getDescription());

			Set<ProjectUserDao> projectUserDaos = projectDao.getProjectUserDaos();

			for (ProjectUserDao projectUserDao : projectUserDaos) {

				if (null != projectUserDao) {
					UserDao userDao = projectUserDao.getUserDao();

					if (null != userDao) {

						User user = new User(userDao.getId(), userDao.getFirstName(),
								userDao.getLastName(), userDao.getUserName(),
								userDao.getPassword());

						user.setCreatedTimestamp(userDao.getCreatedTimestamp());

						project.getMembers().add(user);
					}
				}
			}
		}

		return project;
	}

}
