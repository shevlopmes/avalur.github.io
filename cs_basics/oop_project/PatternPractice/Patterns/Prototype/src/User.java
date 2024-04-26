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

/* TODO: clone method */

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public static void main(String[] args) {
/* TODO: create and clone user, check the result */
        System.out.println("Original user authentication successful: " + isAuthenticatedOriginal);
        System.out.println("Cloned user authentication successful: " + isAuthenticatedCloned);
    }
}
