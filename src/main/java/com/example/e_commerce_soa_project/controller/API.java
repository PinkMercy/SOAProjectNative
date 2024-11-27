package com.example.e_commerce_soa_project.controller;

import com.example.e_commerce_soa_project.dao.DAOCategorie;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import com.example.e_commerce_soa_project.metier.CatalogueMetierImpl;
import com.example.e_commerce_soa_project.metier.ICatalogueMetier;
import com.example.e_commerce_soa_project.entities.Categorie;
import com.example.e_commerce_soa_project.entities.Produit;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/catalogue")
public class API {
    private ICatalogueMetier metier = new CatalogueMetierImpl();

    /**
     * Get all categories
     */
    @GET
    @Path("/categories")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategories() {
        List<Categorie> categories = metier.getAllCategories();
        return Response.ok(categories).build();
    }

    /**
     * Add a new category
     */
    @POST
    @Path("/categories")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCategorie(Categorie categorie) {
        if (categorie == null || categorie.getId() == 0 || categorie.getName() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid category data").build();
        }
        metier.addCategorie(categorie);
        return Response.status(Response.Status.CREATED).build();
    }

    /**
     * Get a category by ID
     */
    @GET
    @Path("/categories/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoryById(@PathParam("id") int id) {
        Categorie categorie = DAOCategorie.getCategorieById(id);
        if (categorie == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Category not found").build();
        }
        return Response.ok(categorie).build();
    }

    /**
     * Get all products
     */
    @GET
    @Path("/produits")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProduits() {
        List<Produit> produits = metier.getAllProduits();
        return Response.ok(produits).build();
    }

    /**
     * Add a new product
     */
    @POST
    @Path("/produits")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduit(Produit produit) {
        if (produit == null || produit.getId() == 0 || produit.getDesignation() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid product data").build();
        }
        metier.addProduit(produit);
        return Response.status(Response.Status.CREATED).build();
    }

    /**
     * Delete a category by ID
     */
    @DELETE
    @Path("/categories/{id}")
    public Response deleteCategory(@PathParam("id") int id) {
        Categorie categorie = DAOCategorie.getCategorieById(id);
        if (categorie == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Category not found").build();
        }
        metier.deleteCategorie(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }



    /**
     * Update a category
     */
    @PUT
    @Path("/categories/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCategory(@PathParam("id") int id, Categorie updatedCategorie) {
        Categorie existingCategory = DAOCategorie.getCategorieById(id);
        if (existingCategory == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Category not found").build();
        }
        if (updatedCategorie.getName() == null || updatedCategorie.getPhoto() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid category data").build();
        }
        updatedCategorie.setId(id); // Ensure ID remains unchanged
        metier.updateCategorie(updatedCategorie); // Delegate the update to the service layer
        return Response.ok(updatedCategorie).build();
    }

}
