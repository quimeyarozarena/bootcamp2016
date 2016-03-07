package finalProject.DAOs;

import finalProject.model.Category;
import finalProject.model.Product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {

    public List<Product> findByCategory(Category category);

    public Product findByName(String name);

    public Product findById(int id);

}
