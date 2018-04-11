package baekjoon;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Prob9465Test {
  Prob9465 app;

  @Before
  public void init() {
    app = new Prob9465();
  }

  @Test
  public void testGetMaxPoint() {
    int input[][] = {{0,50,10,100,20,40},{0,30,50,70,10,60}};
    assertEquals(260,Prob9465.getMaxPoint(input, 5));
    int input2[][] = {{0,10,30,10,50,100,20,40},{0,20,40,30,50,60,20,80}};
    assertEquals(290,Prob9465.getMaxPoint(input2, 7));
  }
}
