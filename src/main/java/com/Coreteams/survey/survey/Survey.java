package com.Coreteams.survey.survey;

import java.util.List;

import com.Coreteams.survey.response.SurveyResponse;
import com.Coreteams.survey.survey.user.enums.Gender;
import com.Coreteams.survey.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="SURVEY")
public class Survey {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
    private Long id;

    @Column(name="TITLE",nullable = false)
    private String title;
    
    @Column(name="GENDER",nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.MALE;

    @Column(name="AGE",nullable = false)
    private int age;

    @Column(name="QUESTIONS",nullable = false)
    @ElementCollection
    private List<String> questions;
    
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
    private List<SurveyResponse> surveyResponse;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER", nullable = false)
    @JsonIgnore
    private User user;

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

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	
    
    

}
