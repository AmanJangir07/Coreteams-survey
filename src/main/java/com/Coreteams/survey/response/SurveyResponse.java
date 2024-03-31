package com.Coreteams.survey.response;

import com.Coreteams.survey.survey.Survey;
import com.Coreteams.survey.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="SURVEY_RESPONSE", uniqueConstraints={
	    @UniqueConstraint(columnNames = {"SURVEY", "USER"})
	})
public class SurveyResponse {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "SURVEY", nullable = false)
    private Survey survey;
    
    @ManyToOne
    @JoinColumn(name = "USER", nullable = false)
    private User user;
    
    @Column(name = "ANSWERS", nullable = false, length = 1000) 
    private String answers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}
    
    

}
