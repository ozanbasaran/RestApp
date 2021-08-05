package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Orders;

import java.util.List;

public interface OrdersService {

    public Orders create(Orders orders);

    public List<Orders> findAll();

    public Orders findById(Long id);

    public Orders update(Orders orders);

    public Orders deleteById(Long id);

}
