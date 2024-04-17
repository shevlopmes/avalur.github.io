import static org.junit.Assert.*;
import org.junit.Test;

public class UserTest {

  @Test
  public void testAuthenticationSuccess() {
    User originalUser = new User("user1", "password123");
    User clonedUser = originalUser.clone();
    assertTrue("Authentication should succeed with correct credentials.",
            clonedUser.authenticate("user1", "password123"));
  }

  @Test
  public void testCloneIndependence() {
    User originalUser = new User("user1", "password123");
    User clonedUser = originalUser.clone();
    assertNotSame("Cloned user should be a separate object instance.",
            originalUser, clonedUser);
  }
}
