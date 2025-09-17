package com.Ecommerce.product_service.Controller;

import com.Ecommerce.product_service.DTOs.ProductRequestDTO;
import com.Ecommerce.product_service.DTOs.ProductResponseDTO;
import com.Ecommerce.product_service.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

//    GET /products → list all products
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getall(@RequestParam(defaultValue = "0") int pagenum,
                                                           @RequestParam(defaultValue = "10") int pagesize){
        return new ResponseEntity<>(productService.getall(pagenum,pagesize), HttpStatus.OK);
    }
//    GET /products/{id} → get product details
    @GetMapping("/{product_id}")
    public ResponseEntity<ProductResponseDTO> getbyId(@PathVariable int product_id){
        return new ResponseEntity<>(productService.getbyID(product_id), HttpStatus.OK);
    }
//    GET /products/{category} → get product details
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getbyCategory(@RequestParam(defaultValue = "0") int pagenum,
                                                           @RequestParam(defaultValue = "10") int pagesize,
                                                                  @PathVariable String category){
        return new ResponseEntity<>(productService.getallByCategory(pagenum,pagesize,category), HttpStatus.OK);
    }
//    POST /products → create new product
    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO requestDTO){
        return new ResponseEntity<>(productService.createnewProduct(requestDTO),HttpStatus.CREATED);
    }
//    @PostMapping
//    public String addProduct(@RequestBody List<ProductRequestDTO> requestDTO){
//        for(ProductRequestDTO requestDTO1 : requestDTO){
//            productService.createnewProduct(requestDTO1);
//        }
//        return "ADDED to DB";
//    }

//    PUT /products/{id} → update product
    @PutMapping("/{product_id}")
    public ResponseEntity<ProductResponseDTO> updateProductDetails(@PathVariable int product_id,@RequestBody ProductRequestDTO requestDTO){
        return new ResponseEntity<>(productService.updateProduct(product_id,requestDTO),HttpStatus.CREATED);
    }
//    DELETE /products/{id} → delete product
    @DeleteMapping("/{product_id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int product_id){
        return new ResponseEntity<>(productService.deleteProduct(product_id),HttpStatus.OK);
    }
}
