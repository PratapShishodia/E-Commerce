package com.Ecommerce.cart_service.Service;

import com.Ecommerce.cart_service.DTOs.CartRequestDTO;
import com.Ecommerce.cart_service.DTOs.CartResponseDTO;
import com.Ecommerce.cart_service.Entity.Cart;
import com.Ecommerce.cart_service.Mappers.CartDTOMapper;
import com.Ecommerce.cart_service.Repository.CartRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartService {

    private CartRepo cartRepo;

    public CartService(CartRepo cartRepo){
        this.cartRepo = cartRepo;
    }

//    POST /cart → add product to cart (with quantity)
    @Transactional
    public CartResponseDTO addProducttoCart(CartRequestDTO requestDTO){
        Cart cart = null;
        if(!cartRepo.existsByUserIDAndProductID(requestDTO.getUserID(),requestDTO.getProductID())){
            cart = CartDTOMapper.toEntity(requestDTO);
        }
        else {
            cart = cartRepo.findByUserIDAndProductID(requestDTO.getUserID(),requestDTO.getProductID());
            cart.setQuantity(cart.getQuantity()+Integer.parseInt(requestDTO.getQuantity()));
        }
        cart.setAddedat(LocalDateTime.now());
        return CartDTOMapper.toDTO(cartRepo.save(cart));
    }
//    GET /cart/{userId} → fetch cart items for a user
    public List<CartResponseDTO> getcartbyUserID(int pagenum,int pagesize,String user_id){
        Pageable pageable = PageRequest.of(pagenum,pagesize);
        Page<Cart> pages = cartRepo.findByUserID(user_id,pageable);
        List<Cart> cartList = pages.getContent();
        return cartList.stream().map(CartDTOMapper::toDTO).toList();
    }

//    PUT /cart/{userId}/items/{productId} → update quantity
    @Transactional
    public CartResponseDTO updateQuantity(String userID, String productID, CartRequestDTO requestDTO){
        Cart cart = cartRepo.findByUserIDAndProductID(userID,productID);
        cart.setQuantity(Integer.parseInt(requestDTO.getQuantity()));
        return CartDTOMapper.toDTO(cartRepo.save(cart));
    }
//    DELETE /cart/{userId}/items/{productId} → remove item
    @Transactional
    public String removeItem(String userID, String productID){
        Cart cart = cartRepo.findByUserIDAndProductID(userID,productID);
        cartRepo.delete(cart);
        return "Item with ID - "+productID+" removed from Cart.";
    }
//    DELETE /cart/{userId} → clear entire cart
    @Transactional
    public String clearCart(String userID){
        List<Cart> cartlist = cartRepo.findByUserID(userID);
        for(Cart cart : cartlist){
            cartRepo.delete(cart);
        }
        return "Cart Emptied";
    }
}
