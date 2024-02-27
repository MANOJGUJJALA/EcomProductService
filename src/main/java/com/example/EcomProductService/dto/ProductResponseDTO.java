package com.example.EcomProductService.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {

    private UUID id;
    private double price;

    private String title;

    private String categeory;
    private String description;
    private String image;


}
