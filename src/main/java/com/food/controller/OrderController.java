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

import com.food.entity.Order;
import com.food.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("order")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@GetMapping("order/{oid}")
	public Order getOrder(@PathVariable("oid") int oid) {
		return orderService.getOrder(oid);
	}
	
	@PostMapping("order")
	public ResponseEntity<Order> addOrder(@RequestBody Order o){
		return ResponseEntity.ok(orderService.addOrder(o));
	}
	
	@PutMapping("order/{oid}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order o, @PathVariable("oid") int oid){
		return ResponseEntity.ok(orderService.updateOrder(o,oid));
	}
	
	@DeleteMapping("order/{oid}")
	public String deleteOrder(@PathVariable("oid") int oid){
		return orderService.deleteUser(oid);
	}
}
