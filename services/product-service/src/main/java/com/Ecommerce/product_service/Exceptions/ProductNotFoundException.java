package com.Ecommerce.product_service.Exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String productNotFoundInRepository) {
        super(productNotFoundInRepository);
    }
}
