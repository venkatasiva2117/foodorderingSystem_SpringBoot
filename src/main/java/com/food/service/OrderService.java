package com.food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.entity.Order;
import com.food.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderReposotory;

	public List<Order> getAllOrders() {

		return (List<Order>)orderReposotory.findAll();
	}

	public Order getOrder(int oid) {

		Optional<Order> order = orderReposotory.findById(oid);
		return order.orElse(null);
	}

	public Order addOrder(Order o) {
		return orderReposotory.save(o);
	}

	public Order updateOrder(Order o, int oid) {
		o.setOrderid(oid);
		return orderReposotory.save(o);
		
	}

	public String deleteUser(int oid) {

		if(orderReposotory.existsById(oid)) {
			orderReposotory.deleteById(oid);
			return "Order deleted SucessFully";
		}
		return "NOT DELETED";
	}

}
