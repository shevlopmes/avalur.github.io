class DummyRestaurant {
    // Method to order a burger based on type
    public Burger orderBurger(String type) {
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

// Concrete burger classes
class BeefBurger extends Burger {
    public void prepare() {
        System.out.println("Preparing a beef burger.");
    }
}

class VeggieBurger extends Burger {
    public void prepare() {
        System.out.println("Preparing a veggie burger.");
    }
}

abstract class Burger {
    abstract void prepare();
    void pack() {
        System.out.println("Packing the burger.");
    }
}
