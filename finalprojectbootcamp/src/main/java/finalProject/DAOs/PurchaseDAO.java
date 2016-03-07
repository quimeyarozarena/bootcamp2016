package finalProject.DAOs;

import finalProject.model.Purchase;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface PurchaseDAO extends CrudRepository<Purchase, Long> {

}
