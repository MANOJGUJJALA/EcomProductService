package com.example.EcomProductService.dto;

public class FakeStoreProductRequestDTO {
    private double price;

    private String title;

    private String categeory;
    private String description;
    private String image;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategeory() {
        return categeory;
    }

    public void setCategeory(String categeory) {
        this.categeory = categeory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
