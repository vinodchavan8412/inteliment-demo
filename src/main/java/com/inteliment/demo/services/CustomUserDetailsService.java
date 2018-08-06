/*package com.inteliment.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inteliment.demo.models.CustomUserDetails;
import com.inteliment.demo.models.User;
import com.inteliment.demo.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserService {

	@Autowired
	private UserRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> usersOptional = usersRepository.findByEmailId(email);
		// System.out.println("usersOptional==="+usersOptional.toString());
		usersOptional.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		// System.out.println("after username not found");
		return usersOptional.map(CustomUserDetails::new).get();
	}
}
*/