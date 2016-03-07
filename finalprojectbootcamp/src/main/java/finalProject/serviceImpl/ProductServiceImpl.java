package finalProject.serviceImpl;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import finalProject.DAOs.ProductDAO;
import finalProject.model.Category;
import finalProject.model.Product;
import finalProject.services.ProductService;
import java.util.List;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@Api(value = "productService", description = "Products Service Implement")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/getByCategory/", method = RequestMethod.GET)
    @ApiOperation(value = "return product by category", response = Boolean.class, notes = "Return product")
    @ApiResponse(code = 200, message = "product was returned successfully")
    public @ResponseBody List<Product> getProductByCategory(@QueryParam("idCategory") int idCategory) {

        Category category = new Category(idCategory);
        List<Product> products = productDAO.findByCategory(category);
        return products;

    }

    @RequestMapping(value = "/getByname", method = RequestMethod.GET)
    @ApiOperation(value = "return product by name", response = Boolean.class, notes = "Return product")
    @ApiResponse(code = 200, message = "product was returned successfully")
    public Product getProductByName(@QueryParam("name") String name) {

        return productDAO.findByName(name);
    }

}