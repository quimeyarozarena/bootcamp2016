package servicesImpl;

import model.Cart;
import model.Product;
import services.CartService;

public class CartServiceImpl implements CartService {

    private Cart cart;

    public CartServiceImpl() {

        cart = new Cart();

    }

    public String add(Product product) {

        cart.getProducts().add(product);

        return "save successfully";
    }

    public String remove(Product product) {

        if (cart.getProducts().contains(product)) {
            cart.getProducts().remove(product);
        }

        return "remove successfully";
    }

    public Cart getCart() {
        return cart;
    }

}
