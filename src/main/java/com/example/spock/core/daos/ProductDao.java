package com.example.spock.core.daos;

import com.example.spock.core.models.ProductModel;

import java.util.Set;

public interface ProductDao
{
    ProductModel findById(Integer id);

    Set<ProductModel> findAll();

    ProductModel save(ProductModel product);

}
