public class DummyDiablo {
    public void setupGame() {
        System.out.println("Loading Diablo data from local storage...");
        System.out.println("Creating Diablo game objects...");
        System.out.println("Downloading Diablo additional files...");
        System.out.println("Cleaning temporary files...");
        System.out.println("Initializing Diablo profiles...");
    }

    public static void main(String[] args) {
        Diablo diablo = new Diablo();
        diablo.setupGame();
    }
}
