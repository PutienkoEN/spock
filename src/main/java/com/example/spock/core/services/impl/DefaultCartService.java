package com.example.spock.core.services.impl;

import com.example.spock.core.models.CartModel;
import com.example.spock.core.models.ProductModel;
import com.example.spock.core.services.CartService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class DefaultCartService implements CartService
{
    @Override
    public void calculateCart(final CartModel cart)
    {
        final Set<ProductModel> products = cart.getProducts();

        final BigDecimal totalPrice = products.stream()
                .map(ProductModel::getPrice)
                .map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        cart.setTotalPrice(totalPrice.doubleValue());
    }
}
