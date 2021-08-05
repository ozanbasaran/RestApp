package com.finartz.RestApp.service.impl;

import com.finartz.RestApp.model.Orders;
import com.finartz.RestApp.repository.OrdersRepository;
import com.finartz.RestApp.service.MenuService;
import com.finartz.RestApp.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Orders create(Orders orders){
        return ordersRepository.save(orders);
    }

    @Override
    public List<Orders> findAll(){
        return ordersRepository.findAll();
    }

    @Override
    public Orders findById(Long id){
        return ordersRepository.getById(id);
    }

    @Override
    public Orders update(Orders orders){
        Orders foundOrders = ordersRepository.getById(orders.getId());

        if (orders.getTotalPrice() != null)
            foundOrders.setTotalPrice(orders.getTotalPrice());
        if (orders.getBasket() != null)
            foundOrders.setBasket(orders.getBasket());
        if (orders.getDate() != null)
            foundOrders.setDate(orders.getDate());
        if (orders.getCreditCard() != null)
            foundOrders.setCreditCard(orders.getCreditCard());

        return ordersRepository.save(foundOrders);
    }

    @Override
    public Orders deleteById(Long id){
        Orders orders = ordersRepository.getById(id);
        if (orders != null) {
            ordersRepository.deleteById(id);
            return orders;
        }
        return orders;
    }
}