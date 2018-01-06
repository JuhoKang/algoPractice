package chap16;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class Prob6Test {

  private Prob6 app;
  private final int[] arrA = {1, 3, 15, 11, 2};
  private final int[] arrB = {23, 127, 235, 19, 8};
  private List<Integer> listA;
  private List<Integer> listB;

  @Before
  public void init() {
    app = new Prob6();
    listA = Arrays.asList(1, 3, 15, 11, 2);
    listB = Arrays.asList(23, 127, 235, 19, 8);
  }

  @Test
  public void 두배열의_최소차_구하기() {
    assertEquals(3, app.getMinDiffOfArrays(arrA, arrB));
  }

  @Test
  public void 두배열의_최소차_대상_구하기() {
    int[] arr = app.getNumsWithDiffFromArrays(arrA, arrB, app.getMinDiffOfArrays(arrA, arrB));
    assertEquals(11, arr[0]);
    assertEquals(8, arr[1]);
  }

  @Test
  public void 리스트변환하기() {
    List<Prob6Element> resultList = new ArrayList<Prob6Element>();
    for (int e : listA) {
      resultList.add(new Prob6Element(0, e));
    }
    for (int e : listB) {
      resultList.add(new Prob6Element(1, e));
    }
    Collections.sort(resultList);
    for (Prob6Element e : resultList) {
      System.out.println(e);
    }
    //assertEquals();
  }

}
