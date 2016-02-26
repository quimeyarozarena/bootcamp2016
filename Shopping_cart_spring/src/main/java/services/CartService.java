package services;

import java.util.Date;
import java.util.List;
import model.Product;

public interface CartService {

    public boolean add(int idproduct, int iduser);

    public boolean remove(int idproduct, int iduser, Date date);

    public List<Product> getCart(int iduser, Date date);
}
