package prob16_5;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Prob16_5Test {

  private Prob16_5 app;

  @Before
  public void init() {
    app = new Prob16_5();
  }

  @Test
  public void 앱테스트() {
    assertEquals(2, app.getZeroCount(app.createFactorial(5)));
  }

  @Test
  public void 팩토리얼생성() {
    assertEquals(6, app.createFactorial(3));
  }

  @Test
  public void 영갯수_맞는가() {
    assertEquals(2, app.getZeroCount(100));
  }

}
