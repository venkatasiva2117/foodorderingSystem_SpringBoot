package com.food.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "orders")
@Table(name = "`orders`")
public class Order {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "restaurantid")
	@JsonIgnore
	private Restaurant restaurant;
	
	private Date orderDate;
	private double totalAmount;
	private String status;
	private String patmentMode;
	
	public Order() {}
	
	@JsonProperty("user_id")
	public Integer getUserId() {
		return (user != null) ? user.getUserId():null;
	}
	@JsonProperty("user_id")
	public void setUserId(Integer userId) {
		if(userId != null) {
			User u = new User();
			u.setUserId(userId);
			this.user = u;
		}
	}

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

	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPatmentMode() {
		return patmentMode;
	}
	public void setPatmentMode(String patmentMode) {
		this.patmentMode = patmentMode;
	}
}
