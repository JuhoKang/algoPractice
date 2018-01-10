package chap8;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Prob2Test {

  Prob2 app;

  @Before
  public void init() {
    app = new Prob2();
  }

  @Test
  public void 실행() {
    int[][] path = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    assertEquals(6, app.calcPaths(path, 3, 3));

    int[][] path2 = {{1, 1}, {1, 1}, {1, 1}};
    assertEquals(3, app.calcPaths(path2, 3, 2));

    int[][] path3 = {{1, 0, 1}, {1, 1, 0}, {1, 1, 1}};
    assertEquals(2, app.calcPaths(path3, 3, 3));

    int[][] path4 = {{1, 1, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 1, 1, 0, 1}, {1, 1, 1, 1, 1}};
    assertEquals(10, app.calcPaths(path4, 4, 5));

  }

}
