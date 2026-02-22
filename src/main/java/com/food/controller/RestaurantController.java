package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.entity.Restaurant;
import com.food.service.RestaurantService;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	
	@GetMapping("restaurant")
	public List<Restaurant> getAllUser() {
		return restaurantService.getAllRestaurant();
	}
	
	@PostMapping("restaurant")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant r){
		Restaurant saved = restaurantService.addRestaurant(r);
		return ResponseEntity.ok(saved);
	}
	
	@GetMapping("restaurant/{rid}")
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable("rid") int rid){
		return ResponseEntity.ok(restaurantService.getRestaurant(rid));
	}
	
	@PutMapping("restaurant/{rid}")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant,@PathVariable("rid") int rid){
		
		Restaurant update = restaurantService.updateRestaurant(restaurant,rid);
		return (update != null) ?ResponseEntity.ok(update):ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("restaurant/{rid}")
	public String deleteRestaurant(@PathVariable("rid") int rid) {
		
		return restaurantService.deleteRestaurant(rid);
	}
	
}
