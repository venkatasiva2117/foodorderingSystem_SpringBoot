package com.food.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name ="orderItems")
@Table(name ="orderItems")
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	
	@ManyToOne
	@JoinColumn(name ="orderid")
	@JsonIgnore
	private Order order;
	
	@ManyToOne
	@JoinColumn(name ="menu_id")
	@JsonIgnore
	private Menu menu;
	private int quantity;
	private double totalPrice;
	
	@JsonProperty("orderid")
	public Integer getOrderId() {
		return (order != null) ? order.getOrderid():null;
	}
	@JsonProperty("orderid")
	public void setOrderId(Integer orderid) {
		if(orderid != null) {
			Order order = new Order();
			order.setOrderid(orderid);
			this.order = order;
		}
	}
	
	@JsonProperty("menuid")
	public Integer getMenuId() {
		return (menu != null) ? menu.getMenu_id():null;
	}
	@JsonProperty("menuid")
	public void setMenuId(Integer menu_id) {
		if(menu_id != null) {
			Menu menu = new Menu();
			menu.setMenu_id(menu_id);
			this.menu = menu;
		}
	}
	
	
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu_id) {
		this.menu = menu_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
}
