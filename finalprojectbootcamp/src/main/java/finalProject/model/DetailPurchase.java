package finalProject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@ApiModel(value = "DetailPurchase entity", description = "Complete info of a entity DetailPurchase")
@Entity
@Table(name = "detail_purchase")
public class DetailPurchase {

    @ApiModelProperty(value = "The id of the detail of purchase", required = true)
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue
    private int id;

    @ApiModelProperty(value = "The purchase of the detail of purchase", required = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "idpurchase", nullable = false) // FK
    @JsonManagedReference(value = "purchase-detailPurchase")
    private Purchase purchase;

    @ApiModelProperty(value = "The cart of the detail of purchase", required = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "idcart", nullable = false) // FK
    @JsonManagedReference(value = "detailPurchase-cart")
    private Cart cart;

    public DetailPurchase() {
        // TODO Auto-generated constructor stub
    }

    public DetailPurchase(Purchase purchase, Cart cart) {

        this.purchase = purchase;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
