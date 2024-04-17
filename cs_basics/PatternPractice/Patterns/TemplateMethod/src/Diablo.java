public class Diablo extends GameSetupTemplate {
    @Override
    protected void loadLocalData() {
        System.out.println("Loading Diablo data from local storage...");
    }

    @Override
    protected void createObjects() {
        System.out.println("Creating Diablo game objects...");
    }

    @Override
    protected void downloadAdditionalFiles() {
        System.out.println("Downloading Diablo additional files...");
    }

    @Override
    protected void initializeProfiles() {
        System.out.println("Initializing Diablo profiles...");
    }
}
