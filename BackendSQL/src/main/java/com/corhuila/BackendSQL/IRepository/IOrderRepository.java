package com.corhuila.BackendSQL.IRepository;

import com.corhuila.BackendSQL.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> { }