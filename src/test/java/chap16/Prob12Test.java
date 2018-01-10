package chap16;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Prob12Test {

  Prob12 app;

  @Before
  public void init() {
    app = new Prob12();
  }

  @Test
  public void 앱테스트() {
    String answer = "1 4 McDowell 5 CA  2 3 Gayle 0 Some Message 0 0";
    String input = "<family lastName=\"McDowell\" state=\"CA\">\n\t<person firstName=\"Gayle\">Some Message</person>\n</family>";
    assertEquals(answer, app.solve(input));
  }

}
