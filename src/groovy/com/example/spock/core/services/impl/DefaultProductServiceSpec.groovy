package com.example.spock.core.services.impl

import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.example.spock.core.daos.ProductDao
import com.example.spock.core.models.ProductModel
import org.junit.Test
import spock.lang.Specification

class DefaultProductServiceSpec extends Specification {

    static final PRODUCT_ID = 1

    @Subject
    DefaultProductService productService

    @Collaborator
    ProductDao productDao = Mock()

    def product = Mock(ProductModel)

    def setup() {

        productDao.findById(PRODUCT_ID) >> product
    }

    @Test
    def "should return product model retrieved from dao"() {
        expect:
            productService.getProductById(PRODUCT_ID) == product
    }

    @Test
    def "should retrieve product with dao"() {
        when:
            productService.getProductById(PRODUCT_ID)
        then:
            1 * productDao.findById(PRODUCT_ID)
    }

    @Test
    def "should return all products retrieved from dao"() {
        given:
            def firstProduct = Mock(ProductModel)
            def secondProduct = Mock(ProductModel)
        and:
            productDao.findAll() >> [firstProduct, secondProduct]
        expect:
            productService.getAllProducts() == [firstProduct, secondProduct] as List
    }


}
