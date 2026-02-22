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

import com.food.entity.OrderItems;
import com.food.service.OrderItemsService;

@RestController
public class OrderItemsController {

	@Autowired
	private OrderItemsService orderItemsService;
	
	@GetMapping("orderItems")
	public List<OrderItems> getAllOrderItems(){
		return orderItemsService.getAllOrderItems();
	}
	
	@GetMapping("orderItems/{oid}")
	public OrderItems getOrderItem(@PathVariable("oid") int oid) {
		return orderItemsService.getOrderItem(oid);
	}
	
	@PostMapping("orderItems")
	public ResponseEntity<OrderItems> addOrderItems(@RequestBody OrderItems o){
		
		return ResponseEntity.ok(orderItemsService.addOrderItems(o));
	}
	
	@PutMapping("orderItems/{oid}")
	public ResponseEntity<OrderItems> updateOrderItems(@RequestBody OrderItems  o, @PathVariable("oid") int oid){
		return ResponseEntity.ok(orderItemsService.updateOrderItems(o,oid));
	}
	
	@DeleteMapping("orderItems/{oid}")
	public String deleteOrderItems(@PathVariable("oid") int oid){
		return orderItemsService.deleteOrderItems(oid);
	}
	
	
	
}
