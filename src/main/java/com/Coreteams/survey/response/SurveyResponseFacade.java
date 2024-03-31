package com.Coreteams.survey.response;

import java.util.List;

public interface SurveyResponseFacade {

	SurveyResponse createSurveyResponse(PersistableSurveyResponse persistableSurveyResponse);

	ReadableSurveyResponse getSurveyResponseById(Long id)throws Exception;

	void deleteSurveyResponse(Long id);

	List<ReadableSurveyResponse> getSurveyListResponseById(Long surveyId, Long userId) throws Exception;

}
