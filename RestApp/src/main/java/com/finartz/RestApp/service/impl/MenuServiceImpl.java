package com.finartz.RestApp.service.impl;

import com.finartz.RestApp.model.Menu;
import com.finartz.RestApp.repository.MenuRepository;
import com.finartz.RestApp.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu create(Menu menu){
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> findAll(){
        return menuRepository.findAll();
    }

    @Override
    public Menu findById(Long id){
        return menuRepository.getById(id);
    }

    @Override
    public Menu update(Menu menu) {
        Menu foundMenu = menuRepository.getById(menu.getId());

        if (menu.getBranch() != null)
            foundMenu.setBranch(menu.getBranch());
        if (menu.getMealList() != null)
            foundMenu.setMealList(menu.getMealList());

        return menuRepository.save(foundMenu);
    }

    @Override
    public Menu deleteById(Long id){
        Menu menu = menuRepository.getById(id);
        if (menu != null) {
            menuRepository.deleteById(id);
            return menu;
        }
        return menu;
    }
}
