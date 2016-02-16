package servicesImpl;

import model.Cart;
import model.Product;
import org.junit.Assert;
import org.junit.Test;
import services.CartService;

public class CartServiceImplTest {

    private CartService cartAPI = new CartServiceImpl();
    private Product product = new Product(1, "smart TV", "Sony", 10000);
    private Product product2 = new Product(2, "smartphone", "Motorola", 8954);
    private Cart cart = new Cart();

    @Test
    public void whenSelectAProductThenAddToCart() {
        Assert.assertEquals("save successfully", cartAPI.add(product));

    }

    @Test
    public void whenRemoveAProductThenRemoveFromCart() {
        Assert.assertEquals("remove successfully", cartAPI.remove(product));

    }

    @Test
    public void whenSelectViewThenReturnAllProductInCart() {

        cart.getProducts().add(product);
        cart.getProducts().add(product2);

        cartAPI.add(product);
        cartAPI.add(product2);

        Assert.assertEquals(cart.getProducts(), cartAPI.getCart().getProducts());

    }
}
