abstract class Restaurant {
    // Factory method
    abstract Burger createBurger(String type);

    // Order a burger using the factory method
    public Burger orderBurger(String type) {
        /* TODO: refactor the dummy implementation,
            using Factory Method pattern */
        Burger burger = null;
        if (type.equals("beef")) {
            burger = new BeefBurger();
        } else if (type.equals("veggie")) {
            burger = new VeggieBurger();
        }
        burger.prepare();
        burger.pack();
        return burger;
    }
}

// Concrete implementations of the factory method
class BeefBurgerRestaurant extends Restaurant {
    Burger createBurger(String type) {
        return new BeefBurger();
    }
}

class VeggieBurgerRestaurant extends Restaurant {
    Burger createBurger(String type) {
        return new VeggieBurger();
    }
}
