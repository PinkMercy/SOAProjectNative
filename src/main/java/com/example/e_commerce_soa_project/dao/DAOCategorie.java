package com.example.e_commerce_soa_project.dao;

import com.example.e_commerce_soa_project.entities.Categorie;
import com.example.e_commerce_soa_project.utilitaire.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCategorie {

    private static final Logger LOGGER = Logger.getLogger(DAOCategorie.class.getName());

    // SQL Queries
    private static final String INSERT_CATEGORIE = "INSERT INTO categories (name, photo) VALUES (?, ?)";
    private static final String SELECT_CATEGORIE_BY_ID = "SELECT * FROM categories WHERE id = ?";
    private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM categories";
    private static final String DELETE_CATEGORIE_BY_ID = "DELETE FROM categories WHERE id = ?";
    private static final String UPDATE_CATEGORIE = "UPDATE categories SET name = ?, photo = ? WHERE id = ?";

    /**
     * Add a new category to the database.
     */


    public static boolean addCategorie(Categorie categorie) {
        String query = "INSERT INTO categories (name, photo) VALUES (?, ?)";
        try (Connection conn = Singleton.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            conn.setAutoCommit(true);
            stmt.setString(1, categorie.getName());
            stmt.setString(2, categorie.getPhoto());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Get a category by ID.
     */
    public static Categorie getCategorieById(int id) {
        try (Connection conn = Singleton.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_CATEGORIE_BY_ID)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Categorie(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("photo")
                );
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving category by ID", e);
        }
        return null;
    }

    /**
     * Get all categories.
     */
    public static List<Categorie> getAllCategories() {
        String query = "SELECT * FROM categories";
        List<Categorie> categories = new ArrayList<>();
        try (Connection conn = Singleton.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                categories.add(new Categorie(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("photo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }


    /**
     * Delete a category by ID.
     */
    public static boolean deleteCategorieById(int id) {
        try (Connection conn = Singleton.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_CATEGORIE_BY_ID)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting category", e);
            return false;
        }
    }

    /**
     * Update an existing category.
     */
    public static boolean updateCategorie(Categorie categorie) {
        try (Connection conn = Singleton.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_CATEGORIE)) {

            stmt.setString(1, categorie.getName());
            stmt.setString(2, categorie.getPhoto());
            stmt.setInt(3, categorie.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating category", e);
            return false;
        }
    }
}
