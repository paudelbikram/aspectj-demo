import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import aspectpointcut.CheckOut;
import org.junit.Before;
import org.junit.Test;

public class CheckOutAspectTest {
  private CheckOut checkOut;

  @Before
  public void before() {
    checkOut = new CheckOut();
  }

  @Test
  public void given10AndPlacingOrderFor2() {
    assertTrue(checkOut.placeOrder(2));
  }

  @Test
  public void given10AndPlacingOrderFor20() {
    assertFalse(checkOut.placeOrder(20));
  }
}
