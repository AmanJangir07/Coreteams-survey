package com.Coreteams.survey.survey;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Coreteams.survey.survey.user.enums.Gender;
import com.Coreteams.survey.user.User;

@Service
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
	private SurveyRepository surveyRepository;

	@Override
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Optional<Survey> getSurveyById(Long id) {
        return surveyRepository.findById(id);
    }

    @Override
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Survey updateSurvey(Survey survey) {
    	return surveyRepository.save(survey);
    }
    
    @Override
    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }

	@Override
	public List<Survey> getSurveyByUser(User user) {
		return surveyRepository.findByUser(user);
	}

	@Override
	public List<Survey> getByAgeAndGender(int age, Gender gender) {
		return surveyRepository.findByAgeAndGender(age,gender);
	}



}
