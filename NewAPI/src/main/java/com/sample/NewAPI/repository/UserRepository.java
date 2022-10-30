package com.sample.NewAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.NewAPI.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	
	Users findByUsername(String username);

	

}
