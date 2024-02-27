package com.example.EcomProductService.mapper;


import com.example.EcomProductService.dto.*;
import com.example.EcomProductService.modal.Category;
import com.example.EcomProductService.modal.Price;
import com.example.EcomProductService.modal.Product;

import java.util.List;

public class ProductMapper {


    public static FakeStoreProductRequestDTO ProductRequestDtoToFakeStoreProductRequestDTo(ProductRequestDTO productRequestDTO){

        FakeStoreProductRequestDTO fakeStoreProductRequestDTO=new FakeStoreProductRequestDTO();

        fakeStoreProductRequestDTO.setCategeory(productRequestDTO.getCategeory());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        return fakeStoreProductRequestDTO;

    }


    public static ProductResponseDTO FakeStoreProductResponseDTOToProductResponseDTO (FakeStoreProductResponseDTO fakeStoreProductResponseDTO){

        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        productResponseDTO.setCategeory(fakeStoreProductResponseDTO.getCategeory());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());

        return productResponseDTO;
    }

    public static ProductListResponseDTO convertProductsToProductListResponseDTO(List<Product> products){
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(Product p : products){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setId(p.getUuid());
            productResponseDTO.setImage(p.getImage());
            productResponseDTO.setTitle(p.getTitle());
            productResponseDTO.setPrice(p.getPrice().getAmount());
            productResponseDTO.setDescription(p.getDescription());
            productResponseDTO.setCategeory(p.getCategory().getCategoryName());
            productListResponseDTO.getProducts().add(productResponseDTO);
        }
        return productListResponseDTO;
    }

    public static ProductResponseDTO convertProductToProductResponseDTO(Product p){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(p.getUuid());
        productResponseDTO.setImage(p.getImage());
        productResponseDTO.setTitle(p.getTitle());
        productResponseDTO.setPrice(p.getPrice().getAmount());
        productResponseDTO.setDescription(p.getDescription());
        productResponseDTO.setCategeory(p.getCategory().getCategoryName());
        return productResponseDTO;
    }

    public static Product ProductRequestDtoToProduct(ProductRequestDTO productRequestDTO){

        Product product=new Product();

        Category category=new Category();
        category.setCategoryName(productRequestDTO.getCategeory());
        product.setCategory(category);
        product.setDescription(productRequestDTO.getDescription());
        product.setTitle(productRequestDTO.getTitle());

        product.setImage(productRequestDTO.getImage());

        Price price=new Price();
        price.setAmount(productRequestDTO.getPrice());
        product.setPrice(price);

        return product;
    }




}
