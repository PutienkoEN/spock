package com.example.spock.core.services.impl

import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.example.spock.core.models.CartModel
import com.example.spock.core.models.ProductModel
import org.junit.Test
import spock.lang.Specification
import spock.lang.Unroll
import sun.plugin.dom.exception.InvalidStateException

class DefaultCartServiceSpec extends Specification {

    final static FIRST_PRODUCT_PRICE = 10
    final static SECOND_PRODUCT_PRICE = 200

    @Subject
    DefaultCartService cartService

    @Test
    def "should sum all prices of products in cart"() {
        given:
            def firstProduct = createProduct(price: FIRST_PRODUCT_PRICE)
            def secondProduct = createProduct(price: SECOND_PRODUCT_PRICE)
        and:
            def cart = createCart(products: [firstProduct, secondProduct])
        when:
            cartService.calculateCart(cart)
        then:
            1 * cart.setTotalPrice(FIRST_PRODUCT_PRICE + SECOND_PRODUCT_PRICE)
    }

    @Test
    @Unroll
    def "should return #expectedResult when first product price is #firstProductPrice and second product price is #secondProductPrice"() {
        given:
            def firstProduct = createProduct(price: firstProductPrice)
            def secondProduct = createProduct(price: secondProductPrice)
        and:
            def cart = createCart(products: [firstProduct, secondProduct])
        when:
            cartService.calculateCart(cart)
        then:
            1 * cart.setTotalPrice(expectedResult)
        where:
            firstProductPrice | secondProductPrice | expectedResult
            10                | 200                | 210
            200               | 10                 | 210
            10                | 10                 | 20
    }

    @Test
    @Unroll
    def "should throw InvalidStateException if first product price is #firstProductPrice and second product price is #secondProductPrice"() {
        given:
            def firstProduct = createProduct(price: firstProductPrice)
            def secondProduct = createProduct(price: secondProductPrice)
        and:
            def cart = createCart(products: [firstProduct, secondProduct])
        when:
            cartService.calculateCart(cart)
        then:
            thrown(InvalidStateException)
        where:
            firstProductPrice | secondProductPrice
            null               | 200
            200               | null
            null              | null
    }

    def createCart(def opts = [:]) {
        Mock(CartModel) {
            getProducts() >> opts.products
        }
    }

    def createProduct(def opts = [:]) {
        Mock(ProductModel) {
            getPrice() >> opts.price
        }
    }

}
