package servicesImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Product;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import services.CartService;

public class CartServiceImplTest {

    private static CartService cartAPI;
    private static List<Product> products;
    private static Product product;
    private static Product product2;
    private static Cart cartmock;
    private static List<Product> productsmock;
    private static Cart cart;

    @BeforeClass
    public static void setUp() {

        cart = new Cart();
        cartAPI = new CartServiceImpl();
        product = new Product(1, "smart TV", "Sony", 10000);
        product2 = new Product(2, "smartphone", "Motorola", 8954);
        products = new ArrayList<Product>();
        products.add(product);
        products.add(product2);
        cartmock = mock(Cart.class);
        productsmock = mock(List.class);

        when(cartmock.getProducts()).thenReturn(productsmock);

    }

    @Test
    public void whenSelectAProductThenAddToCart() {
        Assert.assertTrue(cartAPI.add(product));

    }

    @Test
    public void whenRemoveAProductThenRemoveFromCart() {
        cartAPI.add(product);
        Assert.assertTrue(cartAPI.remove(product));

    }

    @Test
    public void whenSelectViewThenReturnAllProductInCart() {

        cartAPI.add(product);
        cartAPI.add(product2);
        Assert.assertEquals(products, cartAPI.getCart());

    }
}
