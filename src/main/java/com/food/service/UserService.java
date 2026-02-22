package com.food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.entity.User;
import com.food.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepository;

	public User addUser(User u) {
		return  userrepository.save(u);
	}

	public List<User> getAllUser() {
		return (List<User>)userrepository.findAll();
	}

	public User getUser(int uid) {
		Optional<User> user = userrepository.findById(uid);
		return user.orElse(null);
	}

	public User updateUser(User u, int uid) {

		if(userrepository.findById(uid) != null) {
			return userrepository.save(u);
		}
		else {
			return null;
		}
	}

	public String deleteUser(int uid) {

		if(userrepository.existsById(uid)) {
			userrepository.deleteById(uid);
			return "user deleted Sucessfully";
		}
		else {
			return "not Deleted";
		}
		
	}
	
	public User login(String email,String password) {
		Optional<User> user = userrepository.findByEmail(email);
		
		if(user.isPresent()) {
			User u = user.get();
			
			if(u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
		
	}
		
	
}
