package com.food.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.entity.OrderItems;

public interface OrderItemsRepository extends CrudRepository<OrderItems, Integer>{

}
