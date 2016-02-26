package servicesImpl;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import db.Database_Connectivity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

@RestController
@RequestMapping("/api/user")
@Api(value = "userService", description = "Users Service Implement")
public class UserServiceImpl implements UserService {

    private List<User> users;
    private Database_Connectivity dc;
    private Statement statement;
    private User user;

    public UserServiceImpl() {

        users = new ArrayList<User>();
        dc = new Database_Connectivity();
        statement = dc.do_db_connection();
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    @ApiOperation(value = "add user", response = User.class, notes = "Returns user was created")
    @ApiResponses({ @ApiResponse(code = 200, message = "user was created successfully") })
    public @ResponseBody User create(@RequestBody User userAdd) {

        ResultSet rs;
        try {
            statement.execute("insert into users (name, lastname, adress, phone)values ('" + userAdd.getName() + "','"
                    + userAdd.getLastname() + "', '" + userAdd.getAddress() + "', '" + userAdd.getPhone() + "')");
            rs = statement.executeQuery(
                    "select id, name, lastname, adress, phone, nickname from users ORDER BY id DESC LIMIT 1");

            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
            }
            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        users.add(user);
        return user;
    }

    @RequestMapping(value = "/readAll", method = RequestMethod.GET)
    @ApiOperation(value = "read all users", response = List.class, notes = "Returns all users")
    @ApiResponses({ @ApiResponse(code = 200, message = "All users returns from db") })
    public List<User> read() {

        ResultSet rs;
        try {
            rs = statement.executeQuery("select id, name, lastname, adress, phone, nickname from users");
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
                users.add(user);
            }
            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return users;
    }

    @RequestMapping(value = "/update/", method = RequestMethod.PUT)
    @ApiOperation(value = "update user", response = User.class, notes = "Returns user was updated")
    @ApiResponses({ @ApiResponse(code = 200, message = "user was updated successfully") })
    public @ResponseBody User update(@RequestBody User userUpdate) {

        ResultSet rs;
        try {
            statement.executeUpdate("update users set name = '" + userUpdate.getName() + "', lastname = '"
                    + userUpdate.getLastname() + "', adress = '" + userUpdate.getAddress() + "', phone = '"
                    + userUpdate.getPhone() + "' where id = '" + userUpdate.getId() + "'");
            rs = statement.executeQuery("select id, name, lastname, adress, phone, nickname from users where id = '"
                    + userUpdate.getId() + "'");

            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
            }
            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return user;
    }

    @RequestMapping(value = "/delete/", method = RequestMethod.DELETE)
    @ApiOperation(value = "delete user", response = Boolean.class, notes = "Returns true if was deleted")
    @ApiResponses({ @ApiResponse(code = 200, message = "user was deleted successfully") })
    public boolean delete(@RequestBody User user) {

        boolean flag = false;
        try {
            statement.execute("delete from users where id = '" + user.getId() + "'");
            flag = true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return flag;

    }

    @RequestMapping(value = "/getbyname/{name}", method = RequestMethod.GET)
    @ApiOperation(value = "find by name", response = User.class, notes = "Return user was found")
    @ApiResponses({ @ApiResponse(code = 200, message = "user was found successfully") })
    public User findByName(@PathVariable String name) {
        ResultSet rs;
        try {
            rs = statement.executeQuery(
                    "select id, name, lastname, adress, phone, nickname from users where name = '" + name + "'");
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
                users.add(user);
            }
            rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/getbynickname/{nickname}", method = RequestMethod.GET)
    @ApiOperation(value = "find by nickname", response = User.class, notes = "Return user was found")
    @ApiResponses({ @ApiResponse(code = 200, message = "user found successfully") })
    public User findByNickname(@PathVariable String nickname) {
        ResultSet rs;
        try {
            rs = statement
                    .executeQuery("select id, name, lastname, adress, phone, nickname from users where nickname = '"
                            + nickname + "'");
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
                users.add(user);
            }
            rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

}
