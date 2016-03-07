package finalProject.DAOs;

import finalProject.model.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserDAO extends CrudRepository<User, Long> {

    @Query("select u from User u where u.username = :username and u.password = :password")
    public User login(@Param("username") String username, @Param("password") String password);

    public User findById(int id);

}
