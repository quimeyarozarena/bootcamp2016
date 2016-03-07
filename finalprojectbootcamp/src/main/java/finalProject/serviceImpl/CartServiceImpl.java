package finalProject.serviceImpl;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import finalProject.DAOs.CartDAO;
import finalProject.DAOs.CartProductDAO;
import finalProject.model.Cart;
import finalProject.model.Cart_product;
import finalProject.model.Product;
import finalProject.model.User;
import finalProject.services.CartService;
import java.util.List;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
@Api(value = "cartService", description = "Cart Service Implement")
public class CartServiceImpl implements CartService {

    @Autowired
    CartDAO cartDAO;

    @Autowired
    CartProductDAO cartProductDAO;

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "save cart", response = Boolean.class, notes = "return true if the cart was save")
    @ApiResponse(code = 200, message = "save successfull")
    public boolean saveCart(@QueryParam("idUser") int idUser, @RequestParam("idproduct") List<Integer> idproduct) {

        Cart cart = new Cart();
        User user = new User(idUser);
        cart.setUser(user);
        Product product = null;
        Cart_product cartProduct = new Cart_product();
        boolean state = false;

        try {
            cart = cartDAO.save(cart);
            for (int x = 0; x < idproduct.size(); x++) {
                product = new Product(idproduct.get(x));
                cartProduct.setCart(cart);
                cartProduct.setProduct(product);
                cartProductDAO.save(cartProduct);
            }

            state = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return state;
    }

}
