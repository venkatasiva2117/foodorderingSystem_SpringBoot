package com.food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.food.entity.Menu;
import com.food.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	public List<Menu> getAllMenus() {
        return (List<Menu>) menuRepository.findAll();
    }

	public Menu getMenu(int mid) {

		Optional<Menu> menu =  menuRepository.findById(mid);
		return menu.orElse(null);
		 
	}

	public Menu addMenu(Menu m) {
		return menuRepository.save(m);
	}

	public Menu updateMenu(Menu m, int mid) {
	    m.setMenu_id(mid); 
	    return menuRepository.save(m);
	}

	public String deleteMenu(int mid) {
		
		if(menuRepository.existsById(mid)) {
			menuRepository.deleteById(mid);
			return "Sucessfully Deleted";
		}
		return "Enter the Valied Menu Id";
		
	}

	
}
