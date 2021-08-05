package com.finartz.RestApp.service.impl;

import com.finartz.RestApp.model.entity.ItemEntity;
import com.finartz.RestApp.repository.ItemRepository;
import com.finartz.RestApp.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemEntity> getItems(){
        List<ItemEntity> itemEntities = itemRepository.findAll();
        return itemEntities;
    }

    @Override
    public ItemEntity getItem(Long id){
        ItemEntity itemEntity = itemRepository.getById(id);
        return itemEntity;
    }

    @Override
    public ItemEntity createItem(ItemEntity itemEntity){
        ItemEntity save = itemRepository.save(itemEntity);
        return save;
    }

    @Override
    public ItemEntity updateItem(ItemEntity itemEntity){
        ItemEntity foundItemEntity = itemRepository.getById(itemEntity.getId());

        if (itemEntity.getName() != null)
            foundItemEntity.setName(itemEntity.getName());
        if (itemEntity.getUnitType() != null)
            foundItemEntity.setUnitType(itemEntity.getUnitType());
        if (itemEntity.getMealEntities() != null)
            foundItemEntity.setMealEntities(itemEntity.getMealEntities());

        return itemRepository.save(itemEntity);

    }

    @Override
    public ItemEntity deleteItem(Long id){
        ItemEntity itemEntity = itemRepository.getById(id);
        if (itemEntity != null) {
            itemRepository.deleteById(id);
            return itemEntity;
        }
        return itemEntity;
    }
}
