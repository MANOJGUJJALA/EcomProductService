package com.example.EcomProductService.service;

import com.example.EcomProductService.Exception.InvalidTitleException;
import com.example.EcomProductService.Exception.ProductNotFoundexception;
import com.example.EcomProductService.dto.ProductListResponseDTO;
import com.example.EcomProductService.dto.ProductRequestDTO;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.mapper.ProductMapper;
import com.example.EcomProductService.modal.Product;
import com.example.EcomProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductServiceDb")
public class ProductServiceDb implements ProductService{

    private ProductRepository productRepository;
//    private final UserServiceClient userServiceClient;

    public ProductServiceDb(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public ProductListResponseDTO getAllProducts()  {
        List<Product> products = productRepository.findAll();
        ProductListResponseDTO productListResponseDTO = ProductMapper.convertProductsToProductListResponseDTO(products);
        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundexception {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        System.out.println("calling ..");
        Product productReqtoProduct=ProductMapper.ProductRequestDtoToProduct(productRequestDTO);

        Product product=productRepository.save(productReqtoProduct);

        ProductResponseDTO productResponseDTO=ProductMapper.convertProductToProductResponseDTO(product);
        return productResponseDTO;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }


    @Override
    public ProductResponseDTO findProductByTitle(String title) throws ProductNotFoundexception, InvalidTitleException {
        // findAll() -> list of all products
        // findById() -> product by productId
        if(title == null || title.isEmpty()){
            throw new InvalidTitleException("title is invalid");
        }
        Product product = productRepository.findByTitle(title);
        if(product == null){
            throw new ProductNotFoundexception("Product with given title is not available");
        }
        ProductResponseDTO responseDTO = ProductMapper.convertProductToProductResponseDTO(product);
        return responseDTO;
    }
}
