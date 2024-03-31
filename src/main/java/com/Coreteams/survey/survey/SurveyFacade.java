package com.Coreteams.survey.survey;

import java.util.List;
import java.util.Optional;

import com.Coreteams.survey.survey.user.enums.Gender;

public interface SurveyFacade {

	List<Survey> getAllSurveys();

	ReadableSurvey getSurveyById(Long id) throws Exception;

	Survey createSurvey(PersistableSurvey persistableSurvey) throws Exception ;

	Survey updateSurvey(PersistableSurvey persistableSurvey) throws Exception;

	void deleteSurvey(Long id);

	List<Survey> getSurveyForUser(Long userId) throws Exception;

	List<ReadableSurvey> getSurveysByAgeAndGender(int age, Gender gender);


}
