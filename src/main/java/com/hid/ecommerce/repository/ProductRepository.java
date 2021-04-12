package com.hid.ecommerce.repository;

import com.hid.ecommerce.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByUserId(String userId);
}
