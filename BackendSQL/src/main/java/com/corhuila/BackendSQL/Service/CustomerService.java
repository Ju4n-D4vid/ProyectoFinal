package com.corhuila.BackendSQL.Service;

import com.corhuila.BackendSQL.Entity.Customer;
import com.corhuila.BackendSQL.IRepository.ICustomerRepository;
import com.corhuila.BackendSQL.IService.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> getAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public Customer update(Long idLong, Customer customer) {
        Customer existingCustomer = iCustomerRepository.findById(idLong).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhone(customer.getPhone());
            return iCustomerRepository.save(existingCustomer);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        iCustomerRepository.deleteById(id);
    }
}