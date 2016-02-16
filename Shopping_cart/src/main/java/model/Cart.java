package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;

    public Cart() {

        products = new ArrayList<Product>();
    }

    public Cart(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
