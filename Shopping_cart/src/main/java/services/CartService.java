package services;

import java.util.List;
import model.Product;

public interface CartService {

    public boolean add(Product product);

    public boolean remove(Product product);

    public List<Product> getCart();
}
