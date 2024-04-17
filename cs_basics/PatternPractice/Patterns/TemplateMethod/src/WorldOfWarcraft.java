public class WorldOfWarcraft extends GameSetupTemplate {
    @Override
    protected void loadLocalData() {
        System.out.println("Loading WoW data from local storage...");
    }

    @Override
    protected void createObjects() {
        System.out.println("Creating WoW game objects...");
    }

    @Override
    protected void downloadAdditionalFiles() {
        System.out.println("Downloading WoW additional files...");
    }

    @Override
    protected void initializeProfiles() {
        System.out.println("Initializing WoW profiles...");
    }
}
