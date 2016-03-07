package finalProject.services;

import finalProject.model.User;
import java.util.List;

public interface UserService {

    public boolean registery(User user);

    public List<User> getAll();

    public boolean login(String username, String password);

}
