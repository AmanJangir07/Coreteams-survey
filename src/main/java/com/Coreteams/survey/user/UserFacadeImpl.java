package com.Coreteams.survey.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeImpl implements UserFacade{
	
	@Autowired
	private UserService userService;

	@Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public ReadableUser getUserById(Long id) throws Exception {
    	Optional<User> user = userService.getUserById(id);
    	if(user==null) {
			throw new Exception("user not exists");
    	}
    	ReadableUser readableUser = new ReadableUser();
    	
    	readableUser.setAge(user.get().getAge());
    	readableUser.setEmail(user.get().getEmail());
    	readableUser.setGender(user.get().getGender());
    	readableUser.setId(user.get().getId());
    	readableUser.setName(user.get().getName());
    	readableUser.setPassword(user.get().getPassword());
    	readableUser.setSurveys(user.get().getSurveys());
    	readableUser.setUserType(user.get().getUserType().toString());
    	
        return readableUser;
    }

    @Override
    public User createUser(PersistableUser persistableUser) {
    	
    	User user = new User();
    	user.setAge(persistableUser.getAge());
    	user.setEmail(persistableUser.getEmail());
    	user.setGender(persistableUser.getGender());
    	user.setId(persistableUser.getId());
    	user.setName(persistableUser.getName());
    	user.setPassword(persistableUser.getPassword());
    	user.setUserType(persistableUser.getUserType());
        return userService.createUser(user);
    }

    @Override
    public User updateUser( PersistableUser persistableUser) throws Exception {
    	
    	if(persistableUser.getId() != null && persistableUser.getId() > 0) {
    		
    	Optional<User> user = userService.getUserById(persistableUser.getId());
    	if(user.isEmpty()) {
			throw new Exception("user not exists");
    	}
    	user.get().setId(persistableUser.getId());
    	user.get().setAge(persistableUser.getAge());
    	user.get().setEmail(persistableUser.getEmail());
    	user.get().setGender(persistableUser.getGender());
    	user.get().setId(persistableUser.getId());
    	user.get().setName(persistableUser.getName());
    	user.get().setPassword(persistableUser.getPassword());
    	user.get().setUserType(persistableUser.getUserType());
        User dbUser = userService.createUser(user.get());
		return dbUser;
    	}else {
    		throw new Exception("Id is null or less then 0");
    	}
        
    }

    @Override
    public void deleteUser(Long id) throws Exception{
    	Optional<User> user = userService.getUserById(id);
    	
    	if(user.isEmpty()) {
    		throw new Exception("User does not exist with id " + id);
    	}
    	
    	
        userService.deleteUser(id);
    }

}
