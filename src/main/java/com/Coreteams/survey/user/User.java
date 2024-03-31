package com.Coreteams.survey.user;

import java.util.List;

import com.Coreteams.survey.survey.Survey;
import com.Coreteams.survey.survey.user.enums.Gender;
import com.Coreteams.survey.survey.user.enums.Usertype;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="NAME",nullable = false)
    private String name;
    
    @Column(name="EMAIL",nullable = false, unique = true)
    private String email;
    
    @Column(name="PASSWORD",nullable = false)
    private String password;
    
    @Column(name="GENDER",nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.MALE;
    
    
    @Column(name="TYPE",nullable = false)
    @Enumerated(EnumType.STRING)
    private Usertype userType = Usertype.COORDINATOR;
    
    @Column(name="AGE",nullable = false)
    private int age;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Survey> surveys;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Usertype getUserType() {
		return userType;
	}

	public void setUserType(Usertype userType) {
		this.userType = userType;
	}

	
    

}
