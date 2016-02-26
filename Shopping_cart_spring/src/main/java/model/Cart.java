package model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(value = "Cart entity", description = "Complete info of a entity cart")
public class Cart {

    @ApiModelProperty(value = "The products of the cart", required = true)
    private List<Product> products;
    @ApiModelProperty(value = "The date of the cart", required = true)
    private Date date;
    @ApiModelProperty(value = "The user of the cart", required = true)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cart() {

        products = new ArrayList<Product>();
        date = new Date();
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
