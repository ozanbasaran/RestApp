package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Menu;

import java.util.List;

public interface MenuService {

    public Menu create(Menu menu);

    public List<Menu> findAll();

    public Menu findById(Long id);

    public Menu update(Menu menu);

    public Menu deleteById(Long id);
}

