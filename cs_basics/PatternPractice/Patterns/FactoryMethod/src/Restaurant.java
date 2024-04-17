abstract class Restaurant {
    // Factory method
    abstract Burger createBurger(String type);

    // Order a burger using the factory method
    public Burger orderBurger(String type) {
        Burger burger = createBurger(type);
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
