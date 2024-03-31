package com.Coreteams.survey.user;

import java.util.List;
import java.util.Optional;

public interface UserService {

	List<User> getAllUsers();

	Optional<User> getUserById(Long id);

	User createUser(User user);


	void deleteUser(Long id);

	User updateUser( User user);

}
