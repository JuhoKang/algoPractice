package chap16;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class Prob19Test {

  Prob19 app;

  @Before
  public void init() {
    app = new Prob19();
  }

  @Test
  public void 앱테스트() {
    int[][] geo = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
    List<Integer> answer = new ArrayList<>();
    answer.add(2);
    answer.add(4);
    answer.add(1);
    assertEquals(answer, app.getPonds(geo, 4));
  }

  @Test
  public void main3() throws Exception {
    int[][] grid = new int[][] {
        {0, 2, 1, 0, 3, 0},
        {0, 1, 0, 1, 1, 3},
        {1, 1, 0, 1, 0, 9},
        {0, 2, 6, 1, 0, 0},
        {1, 0, 0, 1, 0, 0},
        {0, 1, 0, 1, 0, 0},
        {0, 1, 0, 1, 0, 0},
    };

    List<Integer> result = new ArrayList<>();
    result.add(2);
    result.add(3);
    result.add(1);
    result.add(9);
    result.add(7);

    assertEquals(result, app.getPonds(grid, 6));
  }

  @Test
  public void main4() throws Exception {
    int[][] grid = new int[][] {
        {0, 1, 1, 0},
        {1, 1, 1, 1},
        {0, 1, 1, 0},
        {1, 1, 1, 1},
        {0, 1, 1, 0},
    };

    List<Integer> result = new ArrayList<>();
    result.add(1);
    result.add(1);
    result.add(1);
    result.add(1);
    result.add(1);
    result.add(1);

    assertEquals(result, app.getPonds(grid, 5));
  }

  @Test
  public void main5() throws Exception {
    int[][] grid = new int[][] {
        {0, 1, 0, 1, 0},
        {1, 0, 1, 0, 1},
        {0, 1, 0, 1, 0},
        {1, 0, 1, 0, 1},
        {0, 1, 0, 1, 0},
    };

    List<Integer> result = new ArrayList<>();
    result.add(13);

    assertEquals(result, app.getPonds(grid, 5));
  }
}
