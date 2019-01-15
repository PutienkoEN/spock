package com.example.spock.core.services;

import com.example.spock.core.models.ProductModel;

import java.util.Set;

public interface ProductService
{
    ProductModel getProductById(Integer productId);

    Set<ProductModel> findAllProducts();

    ProductModel saveProduct(ProductModel product);
}
