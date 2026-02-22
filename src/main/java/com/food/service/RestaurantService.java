package com.food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.entity.Restaurant;
import com.food.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public Restaurant addRestaurant(Restaurant r) {
		return restaurantRepository.save(r);
	}

	public List<Restaurant> getAllRestaurant() {
		return (List<Restaurant>)restaurantRepository.findAll();
		
	}
	public Restaurant getRestaurant(int rid) {
		
		Optional<Restaurant> restaurant = restaurantRepository.findById(rid);
		return restaurant.orElse(null);
	}

	public Restaurant updateRestaurant(Restaurant restaurant, int rid) {
		Restaurant existingRestarant = restaurantRepository.findById(rid).orElseThrow(() -> new RuntimeException("Restaurent Not Found " + rid));
		
		existingRestarant.setAddress(restaurant.getAddress());
		existingRestarant.setAdminUserId(restaurant.getAdminUserId());
		existingRestarant.setCusineType(restaurant.getCusineType());
		existingRestarant.setEta(restaurant.getEta());
		existingRestarant.setImagePath(restaurant.getImagePath());
		existingRestarant.setIsActive(restaurant.getIsActive());
		existingRestarant.setName(restaurant.getName());
		existingRestarant.setPhoneNumber(restaurant.getPhoneNumber());
		existingRestarant.setRating(restaurant.getRating());
		
		return restaurantRepository.save(existingRestarant);
	}

	public String deleteRestaurant(int rid) {

		if(restaurantRepository.existsById(rid)) {
			restaurantRepository.deleteById(rid);
			return "Restaurant Deleted Sucessfully ";
		}
		return "Restaurant is not deleted";
	}
	
	

}
