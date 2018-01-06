package chap16;

public class Prob6 {

  public static void main(String[] args) {

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

}
