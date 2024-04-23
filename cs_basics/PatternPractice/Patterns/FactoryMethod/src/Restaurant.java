class Restaurant {
    // Factory method
    Burger newBurger(String type) throws Exception {
        return switch (type) {
            case "beef" -> new BeefBurger();
            case "veggie" -> new VeggieBurger();
            default -> throw new Exception("invalid burger type: %s".formatted(type));
        };
    }

    // Order a burger using the factory method
    public Burger orderBurger(String type) throws Exception {
        Burger burger = newBurger(type);
        burger.prepare();
        burger.pack();
        return burger;
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        try {
            restaurant.orderBurger("beef");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
