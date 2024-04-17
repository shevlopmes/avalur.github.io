public class DummyUser {
    private final String username;
    private final String password;

    public DummyUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public static void main(String[] args) {
        DummyUser dummyUser = new DummyUser("user1", "password123");
        boolean isAuthenticated = dummyUser.authenticate("user1", "password123");
        System.out.println("Authentication successful: " + isAuthenticated);
    }
}
