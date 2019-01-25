package com.example.spock.core.daos;

import com.example.spock.core.models.ProductModel;

import java.util.List;

public interface ProductDao
{
    ProductModel findById(Integer id);

    List<ProductModel> findAll();

    ProductModel save(ProductModel product);

}
