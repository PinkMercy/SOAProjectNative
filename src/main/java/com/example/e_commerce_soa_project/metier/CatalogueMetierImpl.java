package com.example.e_commerce_soa_project.metier;


import com.example.e_commerce_soa_project.dao.DAOCategorie;
import com.example.e_commerce_soa_project.dao.DAOProduit;
import com.example.e_commerce_soa_project.entities.Categorie;
import com.example.e_commerce_soa_project.entities.Produit;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogueMetierImpl implements ICatalogueMetier {
    private DAOCategorie DAOCategorie = new DAOCategorie();
    private DAOProduit DAOProduit = new DAOProduit();

    @Override
    public void addCategorie(Categorie categorie) {
        DAOCategorie.addCategorie(categorie);
    }

    @Override
    public void addProduit(Produit produit) {
        DAOProduit.addProduit(produit);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return DAOCategorie.getAllCategories();
    }

    @Override
    public List<Produit> getAllProduits() {
        return DAOProduit.getAllProduits().values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteCategorie(int id) {
        DAOCategorie.deleteCategorieById(id);
    }

    @Override
    public void updateCategorie(Categorie categorie) {
        DAOCategorie.updateCategorie(categorie);
    }



}
