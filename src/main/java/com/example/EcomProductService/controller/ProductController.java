package com.example.EcomProductService.controller;


import com.example.EcomProductService.Exception.ProductNotFoundexception;
import com.example.EcomProductService.dto.ProductListResponseDTO;
import com.example.EcomProductService.dto.ProductRequestDTO;
import com.example.EcomProductService.dto.ProductResponseDTO;
import com.example.EcomProductService.service.ProductService;
import com.example.EcomProductService.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {


    private final ProductService productService;

    public ProductController(@Qualifier("ProductServiceDb") ProductService productService) {
        this.productService = productService;
    }

    //    Field Injection
//    @Autowired
//    @Qualifier("FakeStore")
//    ProductServiceImpl productServiceImpl;


    @GetMapping("/product")
    public ResponseEntity<ProductListResponseDTO>getAllProducts(){

        ProductListResponseDTO productListResponseDTO=productService.getAllProducts();


        return ResponseEntity.ok(productListResponseDTO);
    }



    @GetMapping("/product/{id}")

    public ResponseEntity<ProductResponseDTO> getAllProductBYId(@PathVariable("id") int id) throws ProductNotFoundexception {


        ProductResponseDTO productResponseDTO= productService.getProductById(id);



        return ResponseEntity.ok(productResponseDTO);


//
//        p1.setId(1);
//        p1.setTitle("Iphone 15 pro");
//        p1.setPrice(150000);
//        p1.setImage("www.google.com/images/iphone");
//        p1.setDescription("Kafi Mehnga phone");
//        p1.setCategeory("Electronics");
//
//        ProductResponseDTO p2 =  new ProductResponseDTO();
//        p2.setId(2);
//        p2.setTitle("Macbook Pro");
//        p2.setPrice(250000);
//        p2.setImage("www.google.com/images/macbook");
//        p2.setDescription("Kafi Mehnga laptop");
//        p2.setCategeory("Electronics");
//
//        ProductRequestDTO h=new ProductRequestDTO();
//
//
//        List<ProductResponseDTO> products = Arrays.asList(p1, p2);
//
//        return ResponseEntity .ok(products);

    }

    @PostMapping("/product")

    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO=productService.createProduct(productRequestDTO);

        return ResponseEntity.ok(productResponseDTO);

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id){
        boolean status=productService.deleteProduct(id);

        return ResponseEntity.ok(status);
    }
}
