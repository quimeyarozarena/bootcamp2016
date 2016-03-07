package finalProject.serviceImpl;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import finalProject.DAOs.CartDAO;
import finalProject.DAOs.CartProductDAO;
import finalProject.DAOs.DetailPurchaseDAO;
import finalProject.DAOs.ProductDAO;
import finalProject.DAOs.PurchaseDAO;
import finalProject.DAOs.UserDAO;
import finalProject.model.Cart;
import finalProject.model.DetailPurchase;
import finalProject.model.Product;
import finalProject.model.Purchase;
import finalProject.model.User;
import finalProject.services.PurchaseService;
import java.util.Date;
import java.util.List;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchase")
@Api(value = "purchaseService", description = "Purchase Service Implement")
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    DetailPurchaseDAO detailPurchaseDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    PurchaseDAO purchaseDAO;

    @Autowired
    CartProductDAO cartProductDAO;

    @Autowired
    CartDAO cartDAO;

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    @ApiOperation(value = "return the purchase", response = Boolean.class, notes = "Return purchase")
    @ApiResponse(code = 200, message = "purchase was returned successfully")
    public @ResponseBody Purchase buyProductsInCart(@QueryParam("iduser") int iduser,
            @QueryParam("idcart") int idcart) {

        double total = 0;
        DetailPurchase detailPurchase = null;
        List<Integer> idProducts = cartProductDAO.findByIdCart(idcart);
        Product product = new Product();

        for (Integer id : idProducts) {

            product = productDAO.findById(id);
            total = total + product.getPrice();
        }

        User user = userDAO.findById(iduser);
        Purchase purchase = new Purchase(new Date(), user, total);

        purchaseDAO.save(purchase);

        Cart cart = cartDAO.findById(idcart);

        detailPurchase = new DetailPurchase(purchase, cart);

        detailPurchaseDAO.save(detailPurchase);

        return purchase;

    }

}
