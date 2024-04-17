import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DummyAuthenticationSystemTest {

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
  public void testAuthenticationFailUser() {
    assertFalse("Authentication should fail with incorrect username.",
            authSystem.authenticate("wrongUser", "pass"));
  }

  @Test
  public void testAuthenticationFailPassword() {
    assertFalse("Authentication should fail with incorrect password.",
            authSystem.authenticate("user", "wrongPass"));
  }
}
