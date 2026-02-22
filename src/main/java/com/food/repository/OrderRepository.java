package com.food.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}
