package finalProject.serviceImpl;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import finalProject.DAOs.UserDAO;
import finalProject.model.User;
import finalProject.services.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Api(value = "userService", description = "Users Service Implement")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    private User user;

    public UserServiceImpl() {

        user = null;
    }

    @RequestMapping(value = "/registery", method = RequestMethod.POST)
    @ApiOperation(value = "add user", response = Boolean.class, notes = "Return true if user was created")
    @ApiResponse(code = 200, message = "user was created successfully")
    public @ResponseBody boolean registery(@RequestBody User user) {

        boolean status = false;
        try {
            user = userDAO.save(user);
            if (user != null) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "get all users", response = List.class, notes = "Returns all users")
    @ApiResponses({ @ApiResponse(code = 200, message = "Returns all users from db") })
    public List<User> getAll() {

        List<User> users = new ArrayList<User>();
        try {
            users = (List<User>) userDAO.findAll();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return users;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "login user", response = Boolean.class, notes = "Return true if login was successful")
    @ApiResponse(code = 200, message = "login was successful")
    public boolean login(@QueryParam("username") String username, @QueryParam("password") String password) {
        boolean status = false;

        try {

            user = userDAO.login(username, password);
            if (user != null) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

}
