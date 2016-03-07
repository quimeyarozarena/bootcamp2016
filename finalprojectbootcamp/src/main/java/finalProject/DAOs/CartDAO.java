package finalProject.DAOs;

import finalProject.model.Cart;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CartDAO extends CrudRepository<Cart, Long> {

    public Cart findById(int id);
}
