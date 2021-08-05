package com.finartz.RestApp.service;

import com.finartz.RestApp.model.entity.ItemEntity;

import java.util.List;

public interface ItemService {

    public List<ItemEntity> getItems();

    public ItemEntity getItem(Long id);

    public ItemEntity createItem(ItemEntity itemEntity);

    public ItemEntity updateItem(ItemEntity itemEntity);

    public ItemEntity deleteItem(Long id);
}
