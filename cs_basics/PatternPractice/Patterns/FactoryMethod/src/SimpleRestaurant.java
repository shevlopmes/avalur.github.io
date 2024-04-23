class SimpleRestaurant {
    // Method to order a burger based on type
    public Burger orderBurger(String request) {
        Burger burger = null;
        if (request.equals("beef")) {
            burger = new BeefBurger();
        } else if (request.equals("veggie")) {
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
    int productId;

    abstract void prepare();
    void pack() {
        System.out.println("Packing the burger.");
    }
}
