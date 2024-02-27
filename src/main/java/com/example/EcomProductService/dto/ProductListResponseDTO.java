package com.example.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class ProductListResponseDTO {
    List<ProductResponseDTO>products;

    public ProductListResponseDTO() {
        this.products = new ArrayList<>();
    }

    public List<ProductResponseDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponseDTO> products) {
        this.products = products;
    }
}
