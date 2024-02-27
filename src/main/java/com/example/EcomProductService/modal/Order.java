package com.example.EcomProductService.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ECOM_ORDER")
public class Order extends BaseModel{
    private double price;
    @ManyToMany
    private List<Product> products;
}
