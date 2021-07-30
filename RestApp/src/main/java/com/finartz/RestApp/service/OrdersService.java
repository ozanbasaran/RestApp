package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Orders;
import com.finartz.RestApp.model.Orders;
import com.finartz.RestApp.repository.OrdersRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> findAll(){
        return ordersRepository.findAll();
    }

    public Orders findById(Long id) {
        return ordersRepository.getById(id);
    }

    public Orders create(Orders orders) {
        return ordersRepository.save(orders);
    }

    public Orders update(Orders orders){
        Orders foundOrders = ordersRepository.getById(orders.getId());
        if(orders.getBasket()!=null){
            foundOrders.setBasket(orders.getBasket());
        }
        if(orders.getCreditCard()!=null){
            foundOrders.setCreditCard(orders.getCreditCard());
        }
        if(orders.getDate() != null) {
            foundOrders.setDate(orders.getDate());
        }
        if(orders.getTotalPrice() != null) {
            foundOrders.setTotalPrice(orders.getTotalPrice());
        }
        return ordersRepository.save(orders);
    }

    public void deleteById(Long id){
        ordersRepository.deleteById(id);
    }
}

