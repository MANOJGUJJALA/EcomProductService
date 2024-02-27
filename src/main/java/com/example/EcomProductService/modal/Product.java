package com.example.EcomProductService.modal;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{


    @OneToOne(cascade = CascadeType.ALL)
    private Price price;

    private String title;

    private String categeory;
    private String description;
    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
}
