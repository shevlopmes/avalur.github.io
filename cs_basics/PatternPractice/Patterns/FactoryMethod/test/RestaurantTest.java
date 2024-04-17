import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RestaurantTest {

    @Test
    public void testBeefBurgerRestaurantCreatesBeefBurger() {
        Restaurant beefBurgerRestaurant = new BeefBurgerRestaurant();
        Burger burger = beefBurgerRestaurant.createBurger("beef");
        assertTrue(burger instanceof BeefBurger);
    }

    @Test
    public void testVeggieBurgerRestaurantCreatesVeggieBurger() {
        Restaurant veggieBurgerRestaurant = new VeggieBurgerRestaurant();
        Burger burger = veggieBurgerRestaurant.createBurger("veggie");
        assertTrue(burger instanceof VeggieBurger);
    }
}
