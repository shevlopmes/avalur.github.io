import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SimpleRestaurantTest {

  @Test
  public void testOrderBeefBurger() {
    SimpleRestaurant restaurant = new SimpleRestaurant();
    Burger burger = restaurant.orderBurger("beef");
    assertTrue(burger instanceof BeefBurger);
  }

  @Test
  public void testOrderVeggieBurger() {
    SimpleRestaurant restaurant = new SimpleRestaurant();
    Burger burger = restaurant.orderBurger("veggie");
    assertTrue(burger instanceof VeggieBurger);
  }
}
