package com.food.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.food.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{

	public Optional<Restaurant> findById(int id);
}
