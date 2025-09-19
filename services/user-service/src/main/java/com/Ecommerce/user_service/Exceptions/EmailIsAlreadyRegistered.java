package com.Ecommerce.user_service.Exceptions;

public class EmailIsAlreadyRegistered extends RuntimeException {
    public EmailIsAlreadyRegistered(String s) {
        super(s);
    }
}
