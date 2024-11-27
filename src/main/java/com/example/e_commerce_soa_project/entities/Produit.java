package com.example.e_commerce_soa_project.entities;

public class Produit {
    private int id;
    private String designation;
    private double price;
    private String photo;
    private int categorieId; // Link to Categorie

    public Produit() {
    }

    public Produit(int id, String designation, double price, String photo, int categorieId) {
        this.id = id;
        this.designation = designation;
        this.price = price;
        this.photo = photo;
        this.categorieId = categorieId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                ", categorieId=" + categorieId +
                '}';
    }
}

