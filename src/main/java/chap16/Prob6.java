package chap16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob6 {

  public static void main(String[] args) {
    final int[] arrA = {1, 3, 15, 11, 2};
    final int[] arrB = {23, 127, 235, 19, 8};
    getMergedElementListAndSort(arrA, arrB);
  }

  public static int getMinDiffOfArrays(int[] arrA, int[] arrB) {
    int diff = Integer.MAX_VALUE;
    for (int i = 0; i < arrA.length; i++) {
      for (int j = 0; j < arrB.length; j++) {
        int tempDiff = Math.abs(arrA[i] - arrB[j]);
        if(diff > tempDiff) {
          diff = tempDiff;
        }
      }
    }
    return diff;
  }

  public static int[] getNumsWithDiffFromArrays(int[] arrA, int[] arrB, int diff) {
    int[] result = new int[2];
    for (int i = 0; i < arrA.length; i++) {
      for (int j = 0; j < arrB.length; j++) {
        int tempDiff = Math.abs(arrA[i] - arrB[j]);
        if(diff == tempDiff) {
          result[0] = arrA[i];
          result[1] = arrB[j];
          break;
        }
      }
    }
    return result;
  }

  public static List<Prob6Element> getMergedElementListAndSort(int[] arrA, int[] arrB) {
    List<Prob6Element> resultList = new ArrayList<Prob6Element>();
    for (int e : arrA) {
      resultList.add(new Prob6Element(0, e));
    }
    for (int e : arrB) {
      resultList.add(new Prob6Element(1, e));
    }
    Collections.sort(resultList);
    for (Prob6Element e : resultList) {
      System.out.println(e);
    }
    return resultList;
  }

  /*public static int getMinDiffFromMergedElementList(List<Prob6Element> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      list.get(i+1) - list.get(i);
    }

    return result;
  }*/
}
