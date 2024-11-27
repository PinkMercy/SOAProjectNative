package com.example.e_commerce_soa_project.metier;


import com.example.e_commerce_soa_project.entities.Categorie;
import com.example.e_commerce_soa_project.entities.Produit;

import java.util.List;

public interface ICatalogueMetier {
    void addCategorie(Categorie categorie);
    void addProduit(Produit produit);
    List<Categorie> getAllCategories();
    List<Produit> getAllProduits();
    void deleteCategorie(int id);

    void updateCategorie(Categorie categorie);

}
