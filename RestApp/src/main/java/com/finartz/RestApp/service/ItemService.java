package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Item;
import com.finartz.RestApp.model.Item;
import com.finartz.RestApp.repository.ItemRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public Item findById(Long id) {
        return itemRepository.getById(id);
    }

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public Item update(Item item){
        Item foundItem = itemRepository.getById(item.getId());
        if(item.getName()!=null){
            foundItem.setName(item.getName());
        }
        return itemRepository.save(item);
    }

    public void deleteById(Long id){
        itemRepository.deleteById(id);
    }
}

