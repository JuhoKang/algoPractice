package chap8;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Prob1Test {

  Prob1 app;

  @Before
  public void init() {
    app = new Prob1();
  }

  @Test
  public void 답구하기() {

    assertEquals(1, app.getClimbCountOf(1));
    assertEquals(0, app.getClimbCountOf(0));
    assertEquals(2, app.getClimbCountOf(2));
    assertEquals(4, app.getClimbCountOf(3));
    assertEquals(7, app.getClimbCountOf(4));
    assertEquals(13, app.getClimbCountOf(5));
    assertEquals(24, app.getClimbCountOf(6));

  }

}
