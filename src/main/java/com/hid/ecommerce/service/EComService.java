package com.hid.ecommerce.service;

import com.hid.ecommerce.model.Product;
import com.hid.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EComService {

    @Autowired
    ProductRepository productRepository;


    @Value("${product.cache.delay}")
    String productCacheDelay;

    @Cacheable(value = "products")
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Cacheable(value = "products", key = "#userId")
    public Iterable<Product> getProducts(String userId) {
        cacheEvict(userId);
        return productRepository
                .findByUserId(userId);
    }

    @CacheEvict(value = "products", allEntries=true)
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @CacheEvict(value = "products", allEntries=true)
    public void remove(Long productId){
        productRepository.deleteById(productId);
    }

    @CacheEvict(value = "products", key = "#userId")
    @Scheduled(fixedDelayString = "productCacheDelay")
    public void cacheEvict(String userId) {}
}
