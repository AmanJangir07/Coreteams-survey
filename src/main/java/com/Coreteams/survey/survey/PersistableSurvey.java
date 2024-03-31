package com.Coreteams.survey.survey;

import java.util.List;

import com.Coreteams.survey.survey.user.enums.Gender;
import com.Coreteams.survey.user.User;

public class PersistableSurvey {
	
	    private Long id;
	    private String title;
	    private Gender gender;
	    private int age;
	    private List<String> questions;
	    private Long userId;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public List<String> getQuestions() {
			return questions;
		}
		public void setQuestions(List<String> questions) {
			this.questions = questions;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		
		
	    
	    

}
