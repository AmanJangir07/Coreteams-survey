package com.Coreteams.survey.user;

import java.util.List;

import org.hibernate.usertype.UserType;

import com.Coreteams.survey.survey.PersistableSurvey;
import com.Coreteams.survey.survey.Survey;
import com.Coreteams.survey.survey.user.enums.Gender;
import com.Coreteams.survey.survey.user.enums.Usertype;

public class PersistableUser {
	
	private Long id;
    private String name;
    private String email;
    private String password;
    private Gender gender;
    private int age;
    private Usertype userType;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	
	public Usertype getUserType() {
		return userType;
	}
	public void setUserType(Usertype userType) {
		this.userType = userType;
	}
}
