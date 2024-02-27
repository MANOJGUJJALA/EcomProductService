package com.example.EcomProductService.service;


import com.example.EcomProductService.Exception.InvalidTitleException;
import com.example.EcomProductService.Exception.ProductNotFoundexception;
import com.example.EcomProductService.dto.ProductListResponseDTO;
import com.example.EcomProductService.dto.ProductRequestDTO;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.modal.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service("ProductServiceImp")
public class ProductServiceImpl implements ProductService{

    RestTemplateBuilder restTemplateBuilder;


    public ProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        String thirdParty="https://fakestoreapi.com/products/";

        RestTemplate restTemplate=restTemplateBuilder.build();

        ResponseEntity<ProductResponseDTO[]>productArray=restTemplate.getForEntity(thirdParty,ProductResponseDTO[].class);

        ProductListResponseDTO productListResponseDTO=new ProductListResponseDTO();

        for(ProductResponseDTO productResponseDTO:productArray.getBody()){

            productListResponseDTO.getProducts().add(productResponseDTO);

        }

        return productListResponseDTO;
    }

    public ProductResponseDTO getProductById(int id){
        String thirdParty="https://fakestoreapi.com/products/"+id;

        RestTemplate restTemplate=restTemplateBuilder.build();

        ResponseEntity<ProductResponseDTO> product=restTemplate.getForEntity(thirdParty,ProductResponseDTO.class);

        return product.getBody();


    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        String thirdParty="https://fakestoreapi.com/products/";

        RestTemplate restTemplate=restTemplateBuilder.build();

        ResponseEntity<ProductResponseDTO>productResponseDTOResponseEntity=
                restTemplate.postForEntity(thirdParty,productRequestDTO,ProductResponseDTO.class);
        return productResponseDTOResponseEntity.getBody();
    }

    @Override
    public boolean deleteProduct(int id) {
        String thirdParty="https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate=restTemplateBuilder.build();

        restTemplate.delete(thirdParty);


        return true;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {


        return null;
    }

    @Override
    public ProductResponseDTO findProductByTitle(String title) throws ProductNotFoundexception, InvalidTitleException {
        return null;
    }

}
