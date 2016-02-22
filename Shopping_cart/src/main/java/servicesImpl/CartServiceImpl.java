package servicesImpl;

import java.util.List;
import model.Cart;
import model.Product;
import services.CartService;

public class CartServiceImpl implements CartService {

    private Cart cart;

    public CartServiceImpl() {

        cart = new Cart();

    }

    public boolean add(Product product) {

        return cart.getProducts().add(product);
    }

    public boolean remove(Product product) {

        return cart.getProducts().remove(product);
    }

    public List<Product> getCart() {
        return cart.getProducts();
    }

}
