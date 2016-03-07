package finalProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@ApiModel(value = "Cart entity", description = "Complete info of a entity cart")
@Entity
@Table(name = "cart")
public class Cart {

    @ApiModelProperty(value = "The id of a cart", required = true)
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue
    private int id;

    @ApiModelProperty(value = "The products of a cart", required = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.cart", cascade = CascadeType.ALL)
    @JsonBackReference(value = "cart-cartproducts")
    private List<Cart_product> cartproducts;

    @ApiModelProperty(value = "The user of a cart", required = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinColumn(name = "iduser", nullable = false) // FK
    @JsonIgnore
    private User user;

    @ApiModelProperty(value = "The details belong to a cart", required = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart", cascade = { CascadeType.ALL })
    @JsonBackReference(value = "detailPurchase-cart")
    public List<DetailPurchase> detailpurchases;

    public Cart() {

    }

    public Cart(int id, User user, List<DetailPurchase> detailpurchases) {
        this.id = id;
        this.user = user;
        this.detailpurchases = detailpurchases;
    }

    public Cart(int idcart) {
        this.id = idcart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DetailPurchase> getDetailpurchases() {
        return detailpurchases;
    }

    public void setDetailpurchases(List<DetailPurchase> detailpurchases) {
        this.detailpurchases = detailpurchases;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Cart_product> getCartproducts() {
        return cartproducts;
    }

    public void setCartproducts(List<Cart_product> cartproducts) {
        this.cartproducts = cartproducts;
    }

}
