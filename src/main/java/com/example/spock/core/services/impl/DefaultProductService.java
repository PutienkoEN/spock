package com.example.spock.core.services.impl;

import com.example.spock.core.daos.ProductDao;
import com.example.spock.core.models.ProductModel;
import com.example.spock.core.services.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class DefaultProductService implements ProductService
{
    @Resource
    private ProductDao productDao;

    @Override
    public ProductModel getProductById(final Integer productId)
    {
        return productDao.findById(productId);
    }

    @Override
    public Set<ProductModel> findAllProducts()
    {
        return productDao.findAll();
    }

    @Override
    public ProductModel saveProduct(final ProductModel product)
    {
        return productDao.save(product);
    }
}
