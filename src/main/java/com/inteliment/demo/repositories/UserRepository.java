package com.inteliment.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inteliment.demo.models.User;




@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	Optional<User> findById(Long userId);
	

}
