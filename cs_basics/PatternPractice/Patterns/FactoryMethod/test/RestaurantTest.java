import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RestaurantTest {

    @Test
    public void testBeefBurgerRestaurantCreatesBeefBurger() throws Exception {
        Restaurant restaurant = new Restaurant();
        Burger burger = restaurant.orderBurger("beef");
        assertTrue(burger instanceof BeefBurger);
    }

    @Test
    public void testVeggieBurgerRestaurantCreatesVeggieBurger() throws Exception {
        Restaurant restaurant = new Restaurant();
        Burger burger = restaurant.orderBurger("veggie");
        assertTrue(burger instanceof VeggieBurger);
    }
}
