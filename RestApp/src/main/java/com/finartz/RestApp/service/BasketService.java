package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Basket;
import com.finartz.RestApp.repository.BasketRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public List<Basket> findAll(){
        return basketRepository.findAll();
    }

    public Basket findById(Long id) {
        return basketRepository.getById(id);
    }

    public Basket create(Basket basket) {
        return basketRepository.save(basket);
    }

    public Basket update(Basket basket){
        Basket foundBasket = basketRepository.getById(basket.getId());
        if (basket.getTotalPrice() != null) {
            foundBasket.setTotalPrice(basket.getTotalPrice());
        }
        return basketRepository.save(basket);
    }

    public void deleteById(Long id){
        basketRepository.deleteById(id);
    }
}