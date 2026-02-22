package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.entity.Menu;
import com.food.service.MenuService;

@CrossOrigin(origins = "*")
@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@GetMapping("menu")
    public List<Menu> getAllMenus() {
		return menuService.getAllMenus();
    }
	
	@GetMapping("menu/{mid}")
	public Menu getMenu(@PathVariable("mid") int mid) {
		return menuService.getMenu(mid);
	}
	
	@PostMapping("menu")
	public ResponseEntity<Menu> addMenu(@RequestBody Menu m){
		Menu menu = menuService.addMenu(m);
				return ResponseEntity.ok(menu);
	}
	
	@PutMapping("menu/{mid}")
	public ResponseEntity<Menu> updateMenu(@RequestBody Menu m,@PathVariable int mid){
		return ResponseEntity.ok(menuService.updateMenu(m,mid));
	}
	
	@DeleteMapping("menu/{mid}")
	public String deleteMenu(@PathVariable int mid){
		return menuService.deleteMenu(mid);
	}
	
}
