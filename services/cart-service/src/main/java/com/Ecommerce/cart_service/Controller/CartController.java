package com.Ecommerce.cart_service.Controller;

import com.Ecommerce.cart_service.DTOs.CartRequestDTO;
import com.Ecommerce.cart_service.DTOs.CartResponseDTO;
import com.Ecommerce.cart_service.Service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

//    POST /cart/{userId}/items → add product to cart (with quantity)
    @PostMapping
    public ResponseEntity<CartResponseDTO> addproduct(@RequestBody CartRequestDTO requestDTO){
        return new ResponseEntity<>(cartService.addProducttoCart(requestDTO), HttpStatus.CREATED);
    }
//    GET /cart/{userId} → fetch cart items for a user
    @GetMapping("/{user_id}")
    public ResponseEntity<List<CartResponseDTO>> getcart(@RequestParam(defaultValue = "0") int pagenum,
                                                         @RequestParam(defaultValue = "10") int pagesize,
                                                         @PathVariable String user_id){
        return new ResponseEntity<>(cartService.getcartbyUserID(pagenum,pagesize,user_id),HttpStatus.OK);
    }
//    PUT /cart/{userId}/items/{productId} → update quantity
    @PutMapping("/{user_id}/items/{product_id}")
    public ResponseEntity<CartResponseDTO> updateQuantity(@PathVariable String user_id,@PathVariable String product_id,@RequestBody CartRequestDTO requestDTO){
        return new ResponseEntity<>(cartService.updateQuantity(user_id,product_id,requestDTO),HttpStatus.CREATED);
    }
//    DELETE /cart/{userId}/items/{productId} → remove item
    @DeleteMapping("/{user_id}/items/{product_id}")
    public ResponseEntity<String> deleteitem(@PathVariable String user_id,@PathVariable String product_id){
        return new ResponseEntity<>(cartService.removeItem(user_id,product_id),HttpStatus.OK);
    }

//    DELETE /cart/{userId} → clear entire cart
    @DeleteMapping("/{user_id}")
    public ResponseEntity<String> clearcart(@PathVariable String user_id){
        return new ResponseEntity<>(cartService.clearCart(user_id),HttpStatus.OK);
    }
}
