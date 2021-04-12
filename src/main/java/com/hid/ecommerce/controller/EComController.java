package com.hid.ecommerce.controller;

import com.hid.ecommerce.model.Product;
import com.hid.ecommerce.service.EComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/api/ecom")
public class EComController {

    @Autowired
    EComService eComService;

    /**
     * Get a specific product by user id
     * @param userId
     * @return
     */
    @GetMapping("/products/{userId}")
    public @NotNull Iterable<Product> getProducts(@PathVariable String userId) {
        return eComService.getProducts(userId);
    }

    /**
     * Add a product
     * @param product
     * @return
     */
    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product){
        return eComService.save(product);
    }

    /**
     * Delete a product
     * @param id
     */
    @DeleteMapping("/product/remove/{id}")
    public void removeProduct(@PathVariable Long id){
        eComService.remove(id);
    }

    /**
     * Get all products
     * @return
     */
    @GetMapping("/products")
    public Iterable<Product> getAllProducts() {
        return eComService.getAllProducts();
    }

}
