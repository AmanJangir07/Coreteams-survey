package com.Coreteams.survey.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SurveyResponseApi {
	
	@Autowired
	private SurveyResponseFacade surveyResponseFacade;
	
	@PostMapping("/survey/response")
    public SurveyResponse createSurveyResponse(@RequestBody PersistableSurveyResponse persistableSurveyResponse) {
        return surveyResponseFacade.createSurveyResponse(persistableSurveyResponse);
    }

    @GetMapping("/survey/response/{id}")
    public ReadableSurveyResponse getSurveyResponseById(@PathVariable Long id) throws Exception{
        return surveyResponseFacade.getSurveyResponseById(id);
    }

    @DeleteMapping("/survey/response/{id}")
    public void deleteSurveyResponse(@PathVariable Long id) {
    	surveyResponseFacade.deleteSurveyResponse(id);
    }
    
    @GetMapping("/survey-responses/{surveyId}/user/{userId}")
    public List<ReadableSurveyResponse> getSurveyResponsesBySurveyId(@PathVariable Long surveyId , @PathVariable Long userId) throws Exception {
        return surveyResponseFacade.getSurveyListResponseById(surveyId , userId);
    }

}
