package com.example.spock.core.services;

import com.example.spock.core.models.ProductModel;

import java.util.List;

public interface ProductService
{
    ProductModel getProductById(Integer productId);

    List<ProductModel> getAllProducts();

    ProductModel saveProduct(ProductModel product);
}
