package com.Coreteams.survey.survey;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.Coreteams.survey.survey.user.enums.Gender;
import com.Coreteams.survey.survey.user.enums.Usertype;
import com.Coreteams.survey.user.ReadableUser;
import com.Coreteams.survey.user.User;
import com.Coreteams.survey.user.UserService;

@Service
public class SurveyFacadeImpl implements SurveyFacade{
	
	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private UserService userService;

	 	@Override
	    public List<Survey> getAllSurveys() {
	        return surveyService.getAllSurveys();
	    }

	    @Override
	    public ReadableSurvey getSurveyById(Long id) throws Exception {
	    	Optional<Survey> survey = surveyService.getSurveyById(id);
	    	if(survey.isEmpty()){
				throw new Exception("survey not exists");
	    	}
	    	
	    	ReadableSurvey readableSurvey = new ReadableSurvey();
	    	ReadableUser readableUser = new ReadableUser();
	    	
	    	readableSurvey.setAge(survey.get().getAge());
	    	readableSurvey.setGender(survey.get().getGender());
	    	readableSurvey.setId(id);
	    	readableSurvey.setQuestions(survey.get().getQuestions());
	    	readableSurvey.setTitle(survey.get().getTitle());
	    	
	    	readableUser.setAge(survey.get().getUser().getAge());
	    	readableUser.setEmail(survey.get().getUser().getEmail());
	    	readableUser.setGender(survey.get().getUser().getGender());
	    	readableUser.setId(survey.get().getUser().getId());
	    	readableUser.setName(survey.get().getUser().getName());
	    	readableUser.setPassword(survey.get().getUser().getPassword());
	    	readableUser.setSurveys(survey.get().getUser().getSurveys());
	    	readableUser.setUserType(survey.get().getUser().getUserType().toString());
	    	readableSurvey.setUser(readableUser);

	        return readableSurvey;
	    }

	    @Override
	    public Survey createSurvey(PersistableSurvey persistableSurvey) throws Exception {
	    	
	    	Optional<User> userOptional = userService.getUserById(persistableSurvey.getUserId());
	        if (userOptional.isEmpty()) {
	            throw new Exception("User not found");
	        }

	        User user = userOptional.get();
	        if (!user.getUserType().equals(Usertype.COORDINATOR)) {
	            throw new Exception("Role is not Coordinator");
	        }

	        Survey survey = new Survey();
	        survey.setTitle(persistableSurvey.getTitle());
	        survey.setGender(persistableSurvey.getGender());
	        survey.setAge(persistableSurvey.getAge());
	        survey.setQuestions(persistableSurvey.getQuestions());
	        survey.setUser(user);

	        return surveyService.createSurvey(survey);
	    }

	    @Override
	    public Survey updateSurvey(PersistableSurvey persistableSurvey) throws Exception {
	    	
	    	if(persistableSurvey.getId() != null &&persistableSurvey.getId() > 0) {
	    		
		    	Optional<Survey> survey = surveyService.getSurveyById(persistableSurvey.getId());
	        	if(survey == null) {
	    			throw new Exception("survey not exists");
	        	}
	        	Optional<User> user = userService.getUserById(persistableSurvey.getUserId());
				if(user.isEmpty()) {
					throw new Exception("user not exists");
				}
	        	if(!user.get().getUserType().equals(Usertype.COORDINATOR)) {
					throw new Exception("Role is not Coordinator");
				}
	        	survey.get().setId(persistableSurvey.getId());
	        	survey.get().setAge(persistableSurvey.getAge());
	        	survey.get().setGender(persistableSurvey.getGender());
	        	survey.get().setQuestions(persistableSurvey.getQuestions());
	        	survey.get().setTitle(persistableSurvey.getTitle());
	        	Survey dbSurvey = surveyService.updateSurvey(survey.get());
	    		return dbSurvey;
	        	}else {
	        		throw new Exception("Id is null or less then 0");
	        	}
	    	
	    }
	    
	    @Override
	    public void deleteSurvey(Long id) {
	        surveyService.deleteSurvey(id);
	    }

		@Override
		public List<Survey> getSurveyForUser(Long userId) throws Exception {
			
			Optional<User> user = userService.getUserById(userId);
			if(user.isEmpty()) {
				throw new Exception("user not exists");
			}
			if(!user.get().getUserType().equals(Usertype.COORDINATOR)) {
				throw new Exception("Role is not Coordinator");
			}
			List<Survey> surveyList= surveyService.getSurveyByUser(user.get());
			return surveyList;
		}

		@Override
		public List<ReadableSurvey> getSurveysByAgeAndGender(int age, Gender gender) {
			List<Survey> surveyList= surveyService.getByAgeAndGender(age,gender);
			List<ReadableSurvey> readableList= new ArrayList<>();
			for(Survey survey:surveyList) {
				readableList.add(convertSurveyToReadableSurvey(survey));
			}
			return readableList;
		}
		
		private static ReadableSurvey convertSurveyToReadableSurvey(Survey survey) {
			ReadableSurvey readableSurvey = new ReadableSurvey();
	    	ReadableUser readableUser = new ReadableUser();
	    	
	    	readableSurvey.setAge(survey.getAge());
	    	readableSurvey.setGender(survey.getGender());
	    	readableSurvey.setId(survey.getId());
	    	readableSurvey.setQuestions(survey.getQuestions());
	    	readableSurvey.setTitle(survey.getTitle());
	    	
	    	readableUser.setAge(survey.getUser().getAge());
	    	readableUser.setEmail(survey.getUser().getEmail());
	    	readableUser.setGender(survey.getUser().getGender());
	    	readableUser.setId(survey.getUser().getId());
	    	readableUser.setName(survey.getUser().getName());
	    	readableUser.setPassword(survey.getUser().getPassword());
	    	readableUser.setSurveys(survey.getUser().getSurveys());
	    	readableUser.setUserType(survey.getUser().getUserType().toString());
	    	readableSurvey.setUser(readableUser);
			return readableSurvey;
		}

}
