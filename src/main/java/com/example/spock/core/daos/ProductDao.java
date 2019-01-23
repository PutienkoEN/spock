package com.example.spock.core.daos;

import com.example.spock.core.models.ProductModel;

import java.util.List;

public interface ProductDao
{
    ProductModel findById(Integer id);

    List<ProductModel> findAll();

    /**
     * Saves product.
     *
     * @param product product to save
     * @throws IllegalArgumentException if passed value is null
     */
    void save(ProductModel product);
}
