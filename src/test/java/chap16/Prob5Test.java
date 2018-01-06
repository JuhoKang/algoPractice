package chap16;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Prob5Test {

  private Prob5 app;
  @Before
  public void init() {
    app = new Prob5();
  }

  @Test
  public void 앱테스트() {
    assertEquals(1, app.getZeroCount(app.createFactorial(5)));
    assertEquals(1, app.countFiveCountUnder(5));
    assertEquals(3, app.countFiveCountUnder(15));
    assertEquals(6, app.countFiveCountUnder(25));
    assertEquals(24, app.countFiveCountUnder(100));
    assertEquals(31, app.countFiveCountUnder(125));
  }

  @Test
  public void 팩토리얼생성() {
    assertEquals(6, app.createFactorial(3));
  }

  @Test
  public void 영갯수_맞는가() {
    assertEquals(2, app.getZeroCount(100));
  }

  @Test
  public void 해당_숫자_아래의_오갯수_세기() {
    assertEquals(0, app.countFiveCountUnder(4));
    assertEquals(1, app.countFiveCountUnder(5));
    assertEquals(3, app.countFiveCountUnder(15));
  }

  @Test
  public void 해당_숫자_오로_몇번나눌수있는가() {
    assertEquals(0, app.howManyFiveDivides(4));
    assertEquals(1, app.howManyFiveDivides(5));
    assertEquals(1, app.howManyFiveDivides(10));
    assertEquals(2, app.howManyFiveDivides(100));
    assertEquals(3, app.howManyFiveDivides(125));
  }

}
