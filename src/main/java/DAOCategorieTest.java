import com.example.e_commerce_soa_project.dao.DAOCategorie;
import com.example.e_commerce_soa_project.entities.Categorie;

public class DAOCategorieTest {
    public static void main(String[] args) {
        // Test adding a category
        Categorie newCategory = new Categorie(0, "Books", "books.jpg");
        if (DAOCategorie.addCategorie(newCategory)) {
            System.out.println("Category added successfully.");
        } else {
            System.err.println("Failed to add category.");
        }
    }
}
