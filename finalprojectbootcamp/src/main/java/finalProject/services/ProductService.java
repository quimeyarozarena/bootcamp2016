package finalProject.services;

import finalProject.model.Product;
import java.util.List;

public interface ProductService {

    public List<Product> getProductByCategory(int idCategory);

    public Product getProductByName(String name);

}
