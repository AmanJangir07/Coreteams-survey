package com.Coreteams.survey.survey;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Coreteams.survey.survey.user.enums.Gender;
import com.Coreteams.survey.user.User;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long>{

	List<Survey> findByUser(User user);

	List<Survey> findByAgeAndGender(int age, Gender gender);

}
