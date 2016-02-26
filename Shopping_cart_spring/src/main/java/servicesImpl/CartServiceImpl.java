package servicesImpl;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import db.Database_Connectivity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Product;
import model.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.CartService;

@RestController
@RequestMapping("/api/cart")
@Api(value = "cart Service", description = "cart Service Implement")
public class CartServiceImpl implements CartService {

    private Database_Connectivity dc;
    private Statement statement;

    public CartServiceImpl() {

        dc = new Database_Connectivity();
        statement = dc.do_db_connection();

    }

    @RequestMapping(value = "/addProduct/{idproduct}/{iduser}", method = RequestMethod.POST)
    @ApiOperation(value = "add product", response = Boolean.class, notes = "return true if user was added")
    @ApiResponses({ @ApiResponse(code = 200, message = "user was added successfully") })
    public boolean add(@PathVariable int idproduct, @PathVariable int iduser) {

        boolean flag = false;
        int idCart = 0;
        ResultSet rs;
        try {

            statement.execute(
                    "insert into cart (datebuy, iduser)values ('" + convert(new Date()) + "', '" + iduser + "') ");
            rs = statement
                    .executeQuery("select id from cart where iduser = '" + iduser + "'  ORDER BY id DESC LIMIT 1");
            while (rs.next()) {
                idCart = rs.getInt(1);
            }
            rs.close();
            statement.execute(
                    "insert into cart_product (idcart, idproduct)values ('" + idCart + "', '" + idproduct + "') ");
            flag = true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return flag;

    }

    @RequestMapping(value = "/removeProduct/{idproduct}/{iduser}/{date}", method = RequestMethod.DELETE)
    @ApiOperation(value = "remove product", response = Boolean.class, notes = "Return true if product was deleted")
    @ApiResponses({ @ApiResponse(code = 200, message = "product was remove successfully") })
    public boolean remove(@PathVariable int idproduct, @PathVariable int iduser,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        int idCart = 0;
        boolean flag = false;
        ResultSet rs;
        try {
            rs = statement.executeQuery(
                    "select id from cart where iduser = '" + iduser + "' and datebuy = '" + convert(date) + "' ");
            while (rs.next()) {
                idCart = rs.getInt(1);
            }
            rs.close();
            statement.execute(
                    "delete from cart_product where idcart = '" + idCart + "' and idproduct = '" + idproduct + "'");
            flag = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return flag;
    }

    @RequestMapping(value = "/getAll/{iduser}/{date}", method = RequestMethod.GET)
    @ApiOperation(value = "get all", response = User.class, notes = "Return all product")
    @ApiResponses({ @ApiResponse(code = 200, message = "get all products in a cart") })
    public List<Product> getCart(@PathVariable int iduser,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        int idCart = 0;
        List<Product> products = new ArrayList<Product>();
        Product product;
        ResultSet rs;
        try {
            rs = statement.executeQuery(
                    "select id from cart where iduser = '" + iduser + "' and datebuy = '" + convert(date) + "' ");
            while (rs.next()) {
                idCart = rs.getInt(1);
            }
            rs.close();
            rs = statement.executeQuery(
                    "select p.id, p.name, p.description, p.price from products p inner join cart_product cp on p.id = cp.idproduct where cp.idcart = '"
                            + idCart + "'");
            while (rs.next()) {
                product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                products.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return products;
    }

    public String convert(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

}
