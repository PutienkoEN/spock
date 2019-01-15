package com.example.spock.core.services.impl;

import com.example.spock.core.daos.ProductDao;
import com.example.spock.core.models.ProductModel;
import com.example.spock.core.services.ProductService;
import org.springframework.stereotype.Service;
import sun.plugin.dom.exception.InvalidStateException;

import javax.annotation.Resource;
import java.util.List;

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
    public List<ProductModel> getAllProducts()
    {
        return productDao.findAll();
    }

    @Override
    public ProductModel saveProduct(final ProductModel product)
    {
        try
        {
            return productDao.save(product);
        }
        catch (InvalidStateException e)
        {
            return null;
        }
    }
}
