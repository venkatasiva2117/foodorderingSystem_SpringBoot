package com.food.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menu_id;
	
	
	@ManyToOne
	@JoinColumn(name ="restaurantid")
	@JsonIgnore
	private Restaurant restaurant;
	
	
	private String itemName;
	private String description;
	private double price;
	private double rating;
	private String isAvailable;
	private String imagePath;
	
	public Menu() {}
	
	
	@JsonProperty("restaurantid")
	public Integer getRestaurantid() {
		return (restaurant != null) ? restaurant.getRestaurantId():null;
	}
	
	@JsonProperty("restaurantid")
	public void setRestaurantid(Integer restaurantId) {
	    if (restaurantId != null) {
	        Restaurant r = new Restaurant();
	        r.setRestaurantId(restaurantId);
	        this.restaurant = r;
	    }
	}


	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	
	
}
