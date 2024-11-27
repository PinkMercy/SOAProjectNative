

import com.example.e_commerce_soa_project.dao.DAOCategorie;
import com.example.e_commerce_soa_project.entities.Categorie;

public class TestDAO {
    public static void main(String[] args) {
        // Initialize DAO
        DAOCategorie daoCategorie = new DAOCategorie();

        // Add categories
        Categorie electronics = new Categorie(1, "Electronics", "electronics.jpg");
        Categorie books = new Categorie(2, "Books", "books.jpg");
        daoCategorie.addCategorie(electronics);
        daoCategorie.addCategorie(books);

        // Test: Retrieve all categories
        System.out.println("All Categories: " + daoCategorie.getAllCategories());

        // Test: Retrieve category by valid ID
        System.out.println("Category with ID 1: " + daoCategorie.getCategorieById(1));

        // Test: Retrieve category by invalid ID
        System.out.println("Category with ID 999: " + daoCategorie.getCategorieById(999));

        // Test: Add category with duplicate ID
        Categorie duplicate = new Categorie(1, "Duplicate", "duplicate.jpg");
        daoCategorie.addCategorie(duplicate);
        System.out.println("After adding duplicate ID: " + daoCategorie.getAllCategories());

        // Test: Remove a category (if delete method is implemented)
        // Uncomment if a delete method is available
        // daoCategorie.removeCategorie(1);
        // System.out.println("After removing category with ID 1: " + daoCategorie.getAllCategories());
    }
}