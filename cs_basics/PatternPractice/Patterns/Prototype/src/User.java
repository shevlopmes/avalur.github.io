public class User implements Prototype {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Copy constructor for cloning
    public User(User user) {
        this.username = user.username;
        this.password = user.password;
    }

    @Override
    public User clone() {
        return new User(this);
    }


    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public static void main(String[] args) {
        User originalUser = new User("user1", "password123");
        User clonedUser = originalUser.clone(); // Cloning the user

        boolean isAuthenticatedOriginal = originalUser.authenticate("user1", "password123");
        boolean isAuthenticatedCloned = clonedUser.authenticate("user1", "password123");

        System.out.println("Original user authentication successful: " + isAuthenticatedOriginal);
        System.out.println("Cloned user authentication successful: " + isAuthenticatedCloned);
    }
}
