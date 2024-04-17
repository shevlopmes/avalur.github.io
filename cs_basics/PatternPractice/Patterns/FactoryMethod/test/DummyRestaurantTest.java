import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DummyRestaurantTest {

  @Test
  public void testOrderBeefBurger() {
    DummyRestaurant restaurant = new DummyRestaurant();
    Burger burger = restaurant.orderBurger("beef");
    assertTrue(burger instanceof BeefBurger);
  }

  @Test
  public void testOrderVeggieBurger() {
    DummyRestaurant restaurant = new DummyRestaurant();
    Burger burger = restaurant.orderBurger("veggie");
    assertTrue(burger instanceof VeggieBurger);
  }
}
