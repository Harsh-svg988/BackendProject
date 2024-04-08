package com.sst.productsevicesst.services;

import com.sst.productsevicesst.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();
}
