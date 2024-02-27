package com.example.EcomProductService.service;

import com.example.EcomProductService.Client.FakeStoreApiClient;
import com.example.EcomProductService.Exception.InvalidTitleException;
import com.example.EcomProductService.Exception.ProductNotFoundexception;
import com.example.EcomProductService.dto.*;
import com.example.EcomProductService.modal.Product;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.EcomProductService.mapper.ProductMapper.FakeStoreProductResponseDTOToProductResponseDTO;
import static com.example.EcomProductService.mapper.ProductMapper.ProductRequestDtoToFakeStoreProductRequestDTo;
import static java.util.Objects.isNull;

@Service("FakeStore")
public class FakeStoreProductService implements ProductService{

    FakeStoreApiClient fakeStoreApiClient;

    public FakeStoreProductService(FakeStoreApiClient fakeStoreApiClient) {
        this.fakeStoreApiClient = fakeStoreApiClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {

    ProductListResponseDTO productListResponseDTO=new ProductListResponseDTO();

        List<FakeStoreProductResponseDTO>fakeStoreProductResponseDTOS=fakeStoreApiClient.getAllProducts();
        for(FakeStoreProductResponseDTO fakeStoreProductResponseDTO:fakeStoreProductResponseDTOS){
            ProductResponseDTO productResponseDTO=FakeStoreProductResponseDTOToProductResponseDTO(fakeStoreProductResponseDTO);
            productListResponseDTO.getProducts().add(productResponseDTO);
        }

        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundexception {

        FakeStoreProductResponseDTO fakeStoreProductResponseDTO= fakeStoreApiClient.getProductById(id);



        if(isNull( fakeStoreProductResponseDTO)){
            throw new ProductNotFoundexception("no prodcu found for this "+id);
        }
        ProductResponseDTO productResponseDTO=FakeStoreProductResponseDTOToProductResponseDTO(fakeStoreProductResponseDTO);

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {

       FakeStoreProductRequestDTO fakeStoreProductRequestDTO= ProductRequestDtoToFakeStoreProductRequestDTo( productRequestDTO);
       FakeStoreProductResponseDTO fakeStoreProductResponseDTO=fakeStoreApiClient.createProduct(fakeStoreProductRequestDTO);

       ProductResponseDTO productResponseDTO=FakeStoreProductResponseDTOToProductResponseDTO(fakeStoreProductResponseDTO);
        return productResponseDTO;
    }

    @Override
    public boolean deleteProduct(int id) {
        fakeStoreApiClient.deleteProductById(id);


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
