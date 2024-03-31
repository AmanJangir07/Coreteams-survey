package com.Coreteams.survey.survey;

import java.util.List;
import java.util.Optional;

import com.Coreteams.survey.survey.user.enums.Gender;
import com.Coreteams.survey.user.User;

public interface SurveyService {

	List<Survey> getAllSurveys();

	Optional<Survey> getSurveyById(Long id);

	Survey createSurvey(Survey survey);

	Survey updateSurvey( Survey survey)throws Exception;

	void deleteSurvey(Long id);

	List<Survey> getSurveyByUser(User user);

	List<Survey> getByAgeAndGender(int age, Gender gender);

}
