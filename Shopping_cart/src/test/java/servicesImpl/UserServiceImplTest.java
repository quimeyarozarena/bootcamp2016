package servicesImpl;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import model.User;
import org.junit.BeforeClass;
import org.junit.Test;
import services.UserService;

public class UserServiceImplTest {

    private static User user;
    private static User user2;
    private static UserService userService;

    @BeforeClass
    public static void setUp() {

        user = new User(1, "Quimey", "Arozarena", "French 3654", "156167352");
        user2 = new User(2, "Florencia", "Diaz", "Lamadrid 2445", "154215094");
        userService = new UserServiceImpl();
    }

    @Test
    public void create() {

        Assert.assertEquals(user, userService.create(user));
    }

    @Test
    public void read() {

        userService.create(user);
        userService.create(user2);

        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user2);

        Assert.assertEquals(users, userService.read());

    }

    @Test
    public void update() {

        user2.setLastname("Venica");
        Assert.assertEquals(user2, userService.update(user2));

    }

    @Test
    public void delete() {

        userService.create(user);
        Assert.assertTrue(userService.delete(user));

    }

}
