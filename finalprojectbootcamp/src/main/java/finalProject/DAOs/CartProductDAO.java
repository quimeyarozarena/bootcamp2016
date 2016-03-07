package finalProject.DAOs;

import finalProject.model.Cart_product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CartProductDAO extends CrudRepository<Cart_product, Long> {

    @Query("select c.pk.product.id from Cart_product c where c.pk.cart.id = :idCart")
    public List<Integer> findByIdCart(@Param("idCart") int idCart);

}
