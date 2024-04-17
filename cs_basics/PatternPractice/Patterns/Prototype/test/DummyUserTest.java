import static org.junit.Assert.*;
import org.junit.Test;

public class DummyUserTest {

  @Test
  public void testAuthenticationSuccess() {
    DummyUser user = new DummyUser("user1", "password123");
    assertTrue("Authentication should succeed with correct credentials.", user.authenticate("user1", "password123"));
  }

  @Test
  public void testAuthenticationFailure() {
    DummyUser user = new DummyUser("user1", "password123");
    assertFalse("Authentication should fail with incorrect credentials.", user.authenticate("user1", "wrongPassword"));
  }
}
