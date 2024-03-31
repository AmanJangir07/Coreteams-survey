package com.Coreteams.survey.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/v1")

public class UserApi {
	
	@Autowired
	private UserFacade userFacade;
	
	@GetMapping("/users")
    public List<User> getAllUsers() {
        return userFacade.getAllUsers();
    }

	@GetMapping("/users/{id}")
	public ReadableUser getUserById(@PathVariable Long id) throws Exception {
	    return userFacade.getUserById(id);
	}

    @PostMapping("/users")
    public User createUser(@RequestBody PersistableUser persistableUser) {
        return userFacade.createUser(persistableUser);
    }

    @PutMapping("/users/update")
    public User updateUser(@RequestBody PersistableUser persistableUser) throws Exception {
        return userFacade.updateUser( persistableUser);
    }
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) throws Exception{
        userFacade.deleteUser(id);
    }

 

}
