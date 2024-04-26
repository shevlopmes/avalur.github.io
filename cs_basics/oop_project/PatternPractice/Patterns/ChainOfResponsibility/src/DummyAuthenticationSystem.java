public class DummyAuthenticationSystem {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public boolean authenticate(String username, String password) {
        if (!username.equals(USERNAME)) {
            System.out.println("User does not exist.");
            return false;
        } else if (!password.equals(PASSWORD)) {
            System.out.println("Password is incorrect.");
            return false;
        }
        System.out.println("User authenticated successfully.");
        return true;
    }

    public static void main(String[] args) {
        DummyAuthenticationSystem authSystem = new DummyAuthenticationSystem();
        boolean isAuthenticated = authSystem.authenticate("user", "pass");
        System.out.println("Authentication successful: " + isAuthenticated);
    }
}
