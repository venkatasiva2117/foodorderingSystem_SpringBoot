package com.food.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.entity.Menu;

public interface MenuRepository extends CrudRepository<Menu ,Integer> {

}
