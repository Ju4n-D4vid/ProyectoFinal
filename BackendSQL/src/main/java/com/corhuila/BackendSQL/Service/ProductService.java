package com.corhuila.BackendSQL.Service;

import com.corhuila.BackendSQL.Entity.Product;
import com.corhuila.BackendSQL.IRepository.IProductRepository;
import com.corhuila.BackendSQL.IService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public Product update(Long idLong, Product product) {
        Product existingProduct = iProductRepository.findById(idLong).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            return iProductRepository.save(existingProduct);
        }
        return null; // O lanzar una excepción
    }

    @Override
    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }
}