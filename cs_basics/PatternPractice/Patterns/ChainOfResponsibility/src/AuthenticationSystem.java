interface Handler {
    void setNext(Handler handler);
    boolean handle(String username, String password);
}

abstract class AbstractHandler implements Handler {
    private Handler next;

    public void setNext(Handler handler) {
        this.next = handler;
    }

    protected boolean handleNext(String username, String password) {
        if (next == null) {
            return true;
        }
        return next.handle(username, password);
    }
}

class UserExistsHandler extends AbstractHandler {
    private static final String USERNAME = "user";

    @Override
    public boolean handle(String username, String password) {
        if (!username.equals(USERNAME)) {
            System.out.println("User does not exist.");
            return false;
        }
        return handleNext(username, password);
    }
}

class PasswordCheckHandler extends AbstractHandler {
    private static final String PASSWORD = "pass";

    @Override
    public boolean handle(String username, String password) {
        if (!password.equals(PASSWORD)) {
            System.out.println("Password is incorrect.");
            return false;
        }
        return handleNext(username, password);
    }
}

public class AuthenticationSystem {
    private Handler start;

    public AuthenticationSystem() {
        start = new UserExistsHandler();
        Handler passwordCheck = new PasswordCheckHandler();

        start.setNext(passwordCheck);
    }

    public boolean authenticate(String username, String password) {
        return start.handle(username, password);
    }

    public static void main(String[] args) {
        AuthenticationSystem authSystem = new AuthenticationSystem();
        boolean isAuthenticated = authSystem.authenticate("user", "pass");
        System.out.println("Authentication successful: " + isAuthenticated);
    }
}
