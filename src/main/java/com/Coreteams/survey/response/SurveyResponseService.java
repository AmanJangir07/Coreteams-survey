package com.Coreteams.survey.response;

import java.util.List;
import java.util.Optional;

import com.Coreteams.survey.survey.Survey;
import com.Coreteams.survey.user.User;

public interface SurveyResponseService {

	SurveyResponse createSurveyResponse(SurveyResponse surveyResponse);

	Optional<SurveyResponse> getSurveyResponseById(Long id);

	void deleteSurveyResponse(Long id);

	List<SurveyResponse> getSurveyResponsesBySurvey(Survey survey);

	List<SurveyResponse> getResponseBySurveyAndUser(Survey survey, User user);

}
