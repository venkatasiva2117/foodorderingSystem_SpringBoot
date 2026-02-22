package com.food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.entity.OrderItems;
import com.food.repository.OrderItemsRepository;

@Service
public class OrderItemsService {

	@Autowired
	private OrderItemsRepository orderItemsRepository;

	public List<OrderItems> getAllOrderItems() {
		return (List<OrderItems>) orderItemsRepository.findAll();
		 
	}

	public OrderItems getOrderItem(int oid) {

		Optional<OrderItems> oi = orderItemsRepository.findById(oid);
		return oi.orElse(null);
		 
	}

	public OrderItems addOrderItems(OrderItems o) {
		if(o != null) {
			return orderItemsRepository.save(o);	
		}
		return null;
	}

	public OrderItems updateOrderItems(OrderItems o, int oid) {

		o.setOrderItemId(oid);
		return orderItemsRepository.save(o);
	}
	
	public String deleteOrderItems(int oid) {
		if(orderItemsRepository.existsById(oid)) {
			orderItemsRepository.deleteById(oid);
			return "OrderItem Deleted SucessFully";
		}
		
		return "OrderItem is Not Deleted";
	}
	
	
	
}
