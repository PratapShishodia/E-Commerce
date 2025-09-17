package com.Ecommerce.product_service.Service;

import com.Ecommerce.product_service.DTOs.ProductRequestDTO;
import com.Ecommerce.product_service.DTOs.ProductResponseDTO;
import com.Ecommerce.product_service.Entity.Product;
import com.Ecommerce.product_service.Exceptions.ProductNotFoundException;
import com.Ecommerce.product_service.Mappers.ProductDTOMapper;
import com.Ecommerce.product_service.Repository.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }


//    GET /products → list all products
    public List<ProductResponseDTO> getall(int pagenum,int pagesize){
        Pageable pageable = PageRequest.of(pagenum,pagesize);
        Page<Product> pages = productRepo.findAll(pageable);
        List<Product> productList = pages.getContent();
        return productList.stream().map(ProductDTOMapper::toDTO).toList();
    }
//    GET /products/{id} → get product details
    public ProductResponseDTO getbyID(Integer product_id){
        Product product = productRepo.findById(product_id).orElseThrow(() -> new ProductNotFoundException("Product not found in Repository"));
        return ProductDTOMapper.toDTO(product);
    }
//    GET /products/{category} → get product details
    public List<ProductResponseDTO> getallByCategory(int pagenum,int pagesize,String category){
        Pageable pageable = PageRequest.of(pagenum,pagesize);
        Page<Product> pages = productRepo.findAllByCategory(category,pageable);
        List<Product> productList = pages.getContent();
        return productList.stream().map(ProductDTOMapper::toDTO).toList();
    }
//    POST /products → create new product
    public ProductResponseDTO createnewProduct(ProductRequestDTO requestDTO){
        Product product = ProductDTOMapper.toEntity(requestDTO);
        product.setCreated_at(LocalDateTime.now());
        return ProductDTOMapper.toDTO(productRepo.save(product));
    }
//    PUT /products/{id} → update product
    public ProductResponseDTO updateProduct(Integer product_id,ProductRequestDTO requestDTO){
        Product product = productRepo.findById(product_id).orElseThrow(() -> new ProductNotFoundException("Product not found in Repository"));
        product.setProductName(requestDTO.getProductName());
        product.setProductDesc(requestDTO.getProductDesc());
        product.setProductPrice(Double.parseDouble(requestDTO.getProductPrice()));
        product.setStock(Integer.valueOf(requestDTO.getStock()));
        product.setUpdated_at(LocalDateTime.now());
        return ProductDTOMapper.toDTO(productRepo.save(product));
    }
//    DELETE /products/{id} → delete product
    public String deleteProduct(Integer product_id){
        productRepo.deleteById(product_id);
        return "Product with ID - "+product_id+" deleted";
    }

}
