package com.Coreteams.survey.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Coreteams.survey.survey.Survey;
import com.Coreteams.survey.survey.SurveyService;
import com.Coreteams.survey.survey.user.enums.Usertype;
import com.Coreteams.survey.user.User;
import com.Coreteams.survey.user.UserService;

@Service
public class SureveyResponseFacadeImpl implements SurveyResponseFacade{
	
	@Autowired
	private SurveyResponseService surveyResponseService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SurveyService surveyService;

	@Override
    public SurveyResponse createSurveyResponse(PersistableSurveyResponse persistableSurveyResponse) {
		
		Optional<Survey> surveyOptional = surveyService.getSurveyById(persistableSurveyResponse.getSurveyId());
	    Optional<User> userOptional = userService.getUserById(persistableSurveyResponse.getUserId());

	    if (surveyOptional.isEmpty()) {
	        throw new IllegalArgumentException("Survey not found for ID: " + persistableSurveyResponse.getSurveyId());
	    }
	    if (userOptional.isEmpty()) {
	        throw new IllegalArgumentException("User not found for ID: " + persistableSurveyResponse.getUserId());
	    }

	    Survey survey = surveyOptional.get();
	    User user = userOptional.get();

	    survey.setUser(user);

	    SurveyResponse surveyResponse = new SurveyResponse();
	    surveyResponse.setUser(user);
	    surveyResponse.setSurvey(survey);
	    surveyResponse.setAnswers(persistableSurveyResponse.getAnswer());

	    return surveyResponseService.createSurveyResponse(surveyResponse);
    }

    @Override
    public ReadableSurveyResponse getSurveyResponseById(Long id) throws Exception {
    	
    	Optional<SurveyResponse> response = surveyResponseService.getSurveyResponseById(id);
    	if(response == null) {
            throw new Exception("not found");
    	}
    	ReadableSurveyResponse readableSurveyResponse = new ReadableSurveyResponse();
    	readableSurveyResponse.setAnswer(response.get().getAnswers());
    	readableSurveyResponse.setId(id);
    	readableSurveyResponse.setSurveyId(response.get().getSurvey().getId());
    	readableSurveyResponse.setUserId(response.get().getUser().getId());
    	
        return readableSurveyResponse;
    }

    @Override
    public void deleteSurveyResponse(Long id) {
        surveyResponseService.deleteSurveyResponse(id);
    }

	@Override
	public List<ReadableSurveyResponse> getSurveyListResponseById(Long surveyId , Long userId) throws Exception{
		
		
		Optional<User> user = userService.getUserById(userId);
		
		if(user.isEmpty()) {
			throw new Exception("User Does not exist");
		}
		
		if(!user.get().getUserType().equals(Usertype.COORDINATOR)) {
			throw new Exception("User is not Coordinator");
		}
		
		Optional<Survey>  survey = surveyService.getSurveyById(surveyId);
		
		if(survey.isEmpty()) {
			throw new Exception("Survey Does not exist");
		}
		List<SurveyResponse> surveyList = surveyResponseService.getResponseBySurveyAndUser(survey.get() , user.get());
	    
		List<ReadableSurveyResponse> responseList = new ArrayList<>();
		
		for(SurveyResponse response :surveyList) {
			responseList.add(convertSurveyToReadableSurvey(response));
		}
	    return responseList;
	}

	private static ReadableSurveyResponse convertSurveyToReadableSurvey (SurveyResponse response) {
		ReadableSurveyResponse readableResponse = new ReadableSurveyResponse();
		readableResponse.setAnswer(response.getAnswers());
		readableResponse.setId(response.getId());
		readableResponse.setSurveyId(response.getSurvey().getId());
		readableResponse.setUserId(response.getUser().getId());
		return readableResponse;
	}
}
