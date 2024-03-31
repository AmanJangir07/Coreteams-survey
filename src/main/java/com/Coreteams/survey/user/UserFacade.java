package com.Coreteams.survey.user;

import java.util.List;
import java.util.Optional;

public interface UserFacade {

	List<User> getAllUsers();

	ReadableUser getUserById(Long id) throws Exception;

	User createUser(PersistableUser persistableUser) ;

	User updateUser( PersistableUser persistableUser)  throws Exception;

	void deleteUser(Long id)throws Exception;


}
