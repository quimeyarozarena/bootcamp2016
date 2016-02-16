package servicesImpl;

import java.util.ArrayList;
import java.util.List;
import model.User;
import services.UserService;

public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl() {

        users = new ArrayList<User>();
    }

    public User create(User user) {

        users.add(user);
        return user;
    }

    public List<User> read() {

        return users;
    }

    public User update(User user) {

        if (users.contains(user.getId())) {
            users.remove(user.getId());
            users.add(user);
        }
        return user;
    }

    public String delete(User user) {

        String adv = "";
        if (users.contains(user)) {
            users.remove(user);
            adv = "deleted successfully";
        }

        return adv;

    }

}
