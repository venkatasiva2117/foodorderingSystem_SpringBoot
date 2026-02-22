package com.food.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.food.entity.User;


public interface UserRepository extends CrudRepository<User, Integer>{

	public Optional<User> findById(int id);
	Optional<User> findByEmail(String email);
}
