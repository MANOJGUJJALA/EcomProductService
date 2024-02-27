package com.example.EcomProductService.controller;


import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.dto.SearchRequestDto;
import com.example.EcomProductService.modal.Product;
import com.example.EcomProductService.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping
    public Page< Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto){

        List<Product>products=    searchService.searchProducts(searchRequestDto.getTitle(),searchRequestDto.getPageNumber(),
                searchRequestDto.getPageSize(),searchRequestDto.getSortParams());

        Page<Product> genericProductDtoPage = new PageImpl<>(
              products
        );
        return genericProductDtoPage;
    }


}
