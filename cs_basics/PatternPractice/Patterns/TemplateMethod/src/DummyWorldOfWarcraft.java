public class DummyWorldOfWarcraft {
    public void setupGame() {
        System.out.println("Loading WoW data from local storage...");
        System.out.println("Creating WoW game objects...");
        System.out.println("Downloading WoW additional files...");
        System.out.println("Cleaning temporary files...");
        System.out.println("Initializing WoW profiles...");
    }

    public static void main(String[] args) {
        WorldOfWarcraft wow = new WorldOfWarcraft();
        wow.setupGame();
    }
}

