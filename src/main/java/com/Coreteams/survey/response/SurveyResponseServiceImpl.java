package com.Coreteams.survey.response;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Coreteams.survey.survey.Survey;
import com.Coreteams.survey.user.User;

@Service
public class SurveyResponseServiceImpl implements SurveyResponseService{
	
	@Autowired
	private SurveyResponseRepository surveyResponseRepository;


	@Override
	public Optional<SurveyResponse> getSurveyResponseById(Long id) {
		return surveyResponseRepository.findById(id);
	}

	@Override
	public void deleteSurveyResponse(Long id) {
		surveyResponseRepository.deleteById(id);
		
	}
	@Override
	public SurveyResponse createSurveyResponse(SurveyResponse surveyResponse) {
		return surveyResponseRepository.save(surveyResponse);
	}

	@Override
	public List<SurveyResponse> getSurveyResponsesBySurvey(Survey survey) {
		List<SurveyResponse> surveyResponses = surveyResponseRepository.findBySurvey(survey);
	    return surveyResponses;
	}

	@Override
	public List<SurveyResponse> getResponseBySurveyAndUser(Survey survey, User user) {
		return surveyResponseRepository.findBySurveyAndUser(survey,user);
	}


}
