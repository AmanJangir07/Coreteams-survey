package com.Coreteams.survey.response;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Coreteams.survey.survey.Survey;
import com.Coreteams.survey.user.User;

@Repository
public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long>{

	List<SurveyResponse> findBySurvey(Survey survey);

	List<SurveyResponse> findBySurveyAndUser(Survey survey, User user);

}
