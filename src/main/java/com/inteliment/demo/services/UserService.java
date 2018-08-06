package com.inteliment.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.inteliment.demo.models.User;




public interface UserService {
	Optional<User> findById(long id);

	User saveUser(User user);


	
}
