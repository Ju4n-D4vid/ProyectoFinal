package com.corhuila.BackendSQL.IService;

import com.corhuila.BackendSQL.Entity.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Customer findById(Long id);
    Customer save(Customer customer);
    Customer update(Long idLong, Customer customer);
    void delete(Long id);
}