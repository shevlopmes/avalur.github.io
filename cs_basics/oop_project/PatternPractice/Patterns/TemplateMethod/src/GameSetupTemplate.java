abstract class GameSetupTemplate {
    public final void setupGame() {
        loadLocalData();
        createObjects();
        downloadAdditionalFiles();
        cleanTemporaryFiles();
        initializeProfiles();
    }

    protected abstract void loadLocalData();
    protected abstract void createObjects();
    protected abstract void downloadAdditionalFiles();
    protected void cleanTemporaryFiles() {
        System.out.println("Cleaning temporary files...");
    }
    protected abstract void initializeProfiles();
}
