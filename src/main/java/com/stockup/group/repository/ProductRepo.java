package com.stockup.group.repository;

import com.stockup.group.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long>{
    Iterable<Product>findAllByProductId(String productId);
}

