package com.example.spock.core.daos;

import com.example.spock.core.models.ProductModel;

import java.util.List;

public interface ProductDao
{
    ProductModel findById(Integer id);

    List<ProductModel> findAll();

    /**
     * @param product
     * @return
     * @throws sun.plugin.dom.exception.InvalidStateException in case product was null
     */
    ProductModel save(ProductModel product);

}
