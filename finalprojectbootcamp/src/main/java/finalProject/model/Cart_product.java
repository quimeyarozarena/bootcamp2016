package finalProject.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cart_product")
@AssociationOverrides({ @AssociationOverride(name = "pk.cart", joinColumns = @JoinColumn(name = "idcart") ),
        @AssociationOverride(name = "pk.product", joinColumns = @JoinColumn(name = "idproduct") ) })
public class Cart_product {

    private CartProductId pk = new CartProductId();

    public Cart_product() {
        // TODO Auto-generated constructor stub
    }

    @EmbeddedId
    public CartProductId getPk() {
        return pk;
    }

    public void setPk(CartProductId pk) {
        this.pk = pk;
    }

    @Transient
    public Cart getCart() {
        return getPk().getCart();
    }

    public void setCart(Cart cart) {
        getPk().setCart(cart);
    }

    @Transient
    public Product getProduct() {
        return getPk().getProduct();
    }

    public void setProduct(Product product) {
        getPk().setProduct(product);
    }

}
