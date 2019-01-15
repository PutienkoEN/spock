package com.example.spock.core.models;

import java.util.Set;

public class CartModel
{
    private Set<ProductModel> products;
    private Double totalPrice;

    public Set<ProductModel> getProducts()
    {
        return products;
    }

    public void setProducts(final Set<ProductModel> products)
    {
        this.products = products;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(final Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
}
