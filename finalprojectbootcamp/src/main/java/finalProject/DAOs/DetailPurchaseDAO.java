package finalProject.DAOs;

import finalProject.model.DetailPurchase;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface DetailPurchaseDAO extends CrudRepository<DetailPurchase, Long> {

}
