package com.example.EcomProductService.service;

import com.example.EcomProductService.Exception.InvalidTitleException;
import com.example.EcomProductService.Exception.ProductNotFoundexception;
import com.example.EcomProductService.dto.ProductListResponseDTO;
import com.example.EcomProductService.dto.ProductRequestDTO;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.modal.Product;

public interface ProductService {

    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(int id) throws ProductNotFoundexception;
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    boolean deleteProduct(int id);
    Product updateProduct(int id, Product updatedProduct);

    ProductResponseDTO findProductByTitle(String title) throws ProductNotFoundexception, InvalidTitleException;
}
