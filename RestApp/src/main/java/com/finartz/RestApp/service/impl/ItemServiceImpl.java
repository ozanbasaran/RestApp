package com.finartz.RestApp.service.impl;

import com.finartz.RestApp.model.Item;
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
    public Item create(Item item){
        Item save = itemRepository.save(item);
        return save;
    }

    @Override
    public List<Item> findAll(){
        List<Item> items = itemRepository.findAll();
        return items;
    }

    @Override
    public Item findById(Long id){
        Item item = itemRepository.getById(id);
        return item;
    }

    @Override
    public Item update(Item item){
        Item foundItem = itemRepository.getById(item.getId());

        if (item.getName() != null)
            foundItem.setName(item.getName());
        if (item.getUnitType() != null)
            foundItem.setUnitType(item.getUnitType());
        if (item.getMealList() != null)
            foundItem.setMealList(item.getMealList());

        return itemRepository.save(item);

    }

    @Override
    public Item deleteById(Long id){
        Item item = itemRepository.getById(id);
        if (item != null) {
            itemRepository.deleteById(id);
            return item;
        }
        return item;
    }
}
