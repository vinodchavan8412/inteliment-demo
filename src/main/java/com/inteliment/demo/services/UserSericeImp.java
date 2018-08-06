package com.inteliment.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.inteliment.demo.dto.SignUpDto;
import com.inteliment.demo.models.User;
import com.inteliment.demo.repositories.UserRepository;





@Service("userService")
@Transactional
public class UserSericeImp implements UserService {

	public static final Logger logger = LoggerFactory.getLogger(UserSericeImp.class);

	@Autowired
	private UserRepository userRepository;
	
	

	// find user by id
	@Transactional
	public Optional<User> findById(long id) {		
		try {
			Optional<User> user = userRepository.findById(id);	
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// save user 
	@Transactional
	public User saveUser(User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public boolean findUserByEmail(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}

	public User signUpUser(SignUpDto signUp) {
		// TODO Auto-generated method stub
		return null;
	}
 
	
	

}
