import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import aspectwithannotation.ProgrammingBlogs;
import org.junit.Test;

public class ProgrammingBlogsAspectTest {

  @Test
  public void getFreeContentSuccessWithNull() {
    assertTrue(ProgrammingBlogs.build(null)
        .getFreeContent().equalsIgnoreCase("This is free content"));
  }

  @Test
  public void getFreeContentSuccessWith100() {
    assertTrue(ProgrammingBlogs.build(100L)
        .getFreeContent().equalsIgnoreCase("This is free content"));
  }

  @Test
  public void getPremiumContentSuccessWith1000() {
    assertTrue(ProgrammingBlogs.build(1000L)
        .getPremiumContent().equalsIgnoreCase("This is premium content"));
  }


  @Test
  public void getPremiumContentSuccessWith2000() {
    assertTrue(ProgrammingBlogs.build(2000L)
        .getPremiumContent().equalsIgnoreCase("This is premium content"));
  }

  @Test
  public void getPremiumContentFailWith1001() {
    assertThrows(IllegalAccessError.class,
        ()->ProgrammingBlogs.build(1001L).getPremiumContent());
  }

  @Test
  public void getPremiumContentFailWithNull() {
    assertThrows(IllegalAccessError.class,
        ()->ProgrammingBlogs.build(null).getPremiumContent());
  }

}
