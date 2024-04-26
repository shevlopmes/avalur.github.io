public class Main {
    public static void main(String[] args) {
        GameSetupTemplate wow = new WorldOfWarcraft();
        wow.setupGame();
        GameSetupTemplate diablo = new Diablo();
        diablo.setupGame();
    }
}
