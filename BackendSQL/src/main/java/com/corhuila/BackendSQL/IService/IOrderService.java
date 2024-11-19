package com.corhuila.BackendSQL.IService;

import com.corhuila.BackendSQL.Entity.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();
    Order findById(Long id);
    Order save(Order order);
    Order update(Long idLong, Order order);
    void delete(Long id);
}