package com.Ecommerce.user_service.Exceptions;

public class UserNameMustBeUniqueException extends RuntimeException {
    public UserNameMustBeUniqueException(String userNameMustBeUnique) {
        super(userNameMustBeUnique);
    }
}
