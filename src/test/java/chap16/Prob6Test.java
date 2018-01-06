package chap16;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Prob6Test {

  private Prob6 app;
  private final int[] arrA = {1, 3, 15, 11, 2};
  private final int[] arrB = {23, 127, 235, 19, 8};

  @Before
  public void init() {
    app = new Prob6();
  }

  @Test
  public void 두배열의_최소차_구하기() {
    assertEquals(3, app.getMinDiffOfArrays(arrA, arrB));
  }

  public void 두배열의_최소차_대상_구하기() {
    int[] arr = app.getMinDiffNumsOfArrays();
    assertEquals()
  }

}
