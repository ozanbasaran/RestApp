package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Menu;
import com.finartz.RestApp.model.Menu;
import com.finartz.RestApp.repository.MenuRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> findAll(){
        return menuRepository.findAll();
    }

    public Menu findById(Long id) {
        return menuRepository.getById(id);
    }

    public Menu create(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu update(Menu menu){
        Menu foundMenu = menuRepository.getById(menu.getId());
        if(menu.getBranch()!=null){
            foundMenu.setBranch(menu.getBranch());
        }
        if(menu.getMealList()!=null){
            foundMenu.setMealList(menu.getMealList());
        }
        return menuRepository.save(menu);
    }

    public void deleteById(Long id){
        menuRepository.deleteById(id);
    }
}

