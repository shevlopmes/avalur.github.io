import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationSystemTest {

    private AuthenticationSystem authSystem;

    @Before
    public void setUp() {
        authSystem = new AuthenticationSystem();
    }

    @Test
    public void testAuthenticationSuccess() {
        assertTrue("Authentication should succeed with correct credentials.",
                authSystem.authenticate("user", "pass"));
    }

    @Test
    public void testUserNotFound() {
        assertFalse("Authentication should fail if the user does not exist.",
                authSystem.authenticate("unknownUser", "pass"));
    }

    @Test
    public void testIncorrectPassword() {
        assertFalse("Authentication should fail if the password is incorrect.",
                authSystem.authenticate("user", "wrongPassword"));
    }
}
