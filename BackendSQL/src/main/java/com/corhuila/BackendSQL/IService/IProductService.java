package com.corhuila.BackendSQL.IService;

import com.corhuila.BackendSQL.Entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product findById(Long id);
    Product save(Product product);
    Product update(Long idLong, Product product);
    void delete(Long id);
}