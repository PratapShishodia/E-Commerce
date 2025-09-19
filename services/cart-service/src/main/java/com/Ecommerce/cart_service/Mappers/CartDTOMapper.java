package com.Ecommerce.cart_service.Mappers;

import com.Ecommerce.cart_service.DTOs.CartRequestDTO;
import com.Ecommerce.cart_service.DTOs.CartResponseDTO;
import com.Ecommerce.cart_service.Entity.Cart;

import java.time.LocalDateTime;

public class CartDTOMapper {
    public static CartResponseDTO toDTO(Cart cart){
        CartResponseDTO responseDTO = new CartResponseDTO();
        responseDTO.setCartID(String.valueOf(cart.getCartID()));
        responseDTO.setUserID(cart.getUserID());
        responseDTO.setProductID(cart.getProductID());
        responseDTO.setQuantity(String.valueOf(cart.getQuantity()));
        responseDTO.setAddedat(String.valueOf(cart.getAddedat()));
        return responseDTO;
    }

    public static Cart toEntity(CartRequestDTO requestDTO){
        Cart cart = new Cart();
        cart.setUserID(requestDTO.getUserID());
        cart.setProductID(requestDTO.getProductID());
        cart.setQuantity(Integer.parseInt(requestDTO.getQuantity()));
        return cart;
    }

}
