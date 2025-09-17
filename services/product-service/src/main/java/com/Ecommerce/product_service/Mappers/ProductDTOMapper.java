package com.Ecommerce.product_service.Mappers;

import com.Ecommerce.product_service.DTOs.ProductRequestDTO;
import com.Ecommerce.product_service.DTOs.ProductResponseDTO;
import com.Ecommerce.product_service.Entity.Product;

public class ProductDTOMapper {
    public static ProductResponseDTO toDTO(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProductId(String.valueOf(product.getProductId()));
        responseDTO.setProductName(product.getProductName());
        responseDTO.setProductDesc(product.getProductDesc());
        responseDTO.setProductPrice(String.valueOf(product.getProductPrice()));
        responseDTO.setCategory(product.getCategory());
        responseDTO.setStock(String.valueOf(product.getStock()));
        responseDTO.setCreated_at(String.valueOf(product.getCreated_at()));
        responseDTO.setUpdated_at(String.valueOf(product.getUpdated_at()));
        return responseDTO;
    }

    public static Product toEntity(ProductRequestDTO requestDTO){
        Product product = new Product();
        product.setProductName(requestDTO.getProductName());
        product.setProductDesc(requestDTO.getProductDesc());
        product.setProductPrice(Double.parseDouble(requestDTO.getProductPrice()));
        product.setCategory(requestDTO.getCategory());
        product.setStock(Integer.valueOf(requestDTO.getStock()));
        return product;
    }

}
