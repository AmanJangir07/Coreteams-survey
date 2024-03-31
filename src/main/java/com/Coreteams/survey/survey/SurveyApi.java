package com.Coreteams.survey.survey;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Coreteams.survey.survey.user.enums.Gender;

@RestController
@RequestMapping("/api/v1")

public class SurveyApi {
	
	@Autowired
	private SurveyFacade surveyFacade;
	
	@GetMapping("/survey")
    public List<Survey> getAllSurveys() {
        return surveyFacade.getAllSurveys();
    }
	
	@GetMapping("/survey/respondent")
    public List<ReadableSurvey> getSurveyByAgeAndGender(@RequestParam(name ="age",required =true) int age,@RequestParam(name = "gender",required = true) Gender gender) {
        return surveyFacade.getSurveysByAgeAndGender(age,gender);
    }
	
    @GetMapping("/survey/{id}")
    public ReadableSurvey getSurveyById(@PathVariable Long id) throws Exception {
        return surveyFacade.getSurveyById(id);
    }

    @PostMapping("/survey") 
    public Survey createSurvey(@RequestBody PersistableSurvey persistableSurvey) throws Exception {
        return surveyFacade.createSurvey(persistableSurvey);
    }
    
    @PutMapping("/survey")
    public Survey updateSurvey(@RequestBody PersistableSurvey persistableSurvey) throws Exception{
        return surveyFacade.updateSurvey(persistableSurvey);
    }
    
    @DeleteMapping("/surveys/{id}")
    public void deleteSurvey(@PathVariable Long id) {
        surveyFacade.deleteSurvey(id);
    }
    
    @GetMapping("/{userId}")
    public List<Survey> getSurveyForUser(@PathVariable Long userId) throws Exception {
        return surveyFacade.getSurveyForUser(userId);
    }


}
