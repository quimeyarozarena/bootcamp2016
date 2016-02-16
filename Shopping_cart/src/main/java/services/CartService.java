package services;

import model.Cart;
import model.Product;

public interface CartService {

    public String add(Product product);

    public String remove(Product product);

    public Cart getCart();
}
