package com.corhuila.BackendSQL.Service;

import com.corhuila.BackendSQL.Entity.Order;
import com.corhuila.BackendSQL.IRepository.IOrderRepository;
import com.corhuila.BackendSQL.IService.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public List<Order> getAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        Optional<Order> order = iOrderRepository.findById(id);
        if (order.isPresent()) {
            return order.get();
        }
        throw new RuntimeException("Order not found with id " + id);
    }

    @Override
    public Order save(Order order) {
        return iOrderRepository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        if (iOrderRepository.existsById(id)) {
            order.setId(id);
            return iOrderRepository.save(order);
        }
        throw new RuntimeException("Order not found with id " + id);
    }

    @Override
    public void delete(Long id) {
        if (iOrderRepository.existsById(id)) {
            iOrderRepository.deleteById(id);
        } else {
            throw new RuntimeException("Order not found with id " + id);
        }
    }
}