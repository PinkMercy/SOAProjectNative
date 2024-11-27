package com.example.e_commerce_soa_project.dao;


import com.example.e_commerce_soa_project.entities.Produit;

import java.util.HashMap;
import java.util.Map;

public class DAOProduit {
    private static Map<Integer, Produit> produits = new HashMap<>();

    public void addProduit(Produit produit) {
        produits.put(produit.getId(), produit);
    }

    public Produit getProduitById(int id) {
        return produits.get(id);
    }

    public Map<Integer, Produit> getAllProduits() {
        return produits;
    }
}
