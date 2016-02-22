package services;

import java.util.List;
import model.User;

public interface UserService {

    public User create(User user);

    public List<User> read();

    public User update(User user);

    public boolean delete(User user);

}
