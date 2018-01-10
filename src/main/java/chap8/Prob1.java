package chap8;

import java.util.Scanner;

public class Prob1 {

  public Prob1() {
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    System.out.println(getClimbCountOf(input, new int[input+1]));
  }

  public int getClimbCountOf(int n, int[] cache) {
    if (n < 1) {
      return 0;
    } else if (n < 3) {
      return n;
    } else if (n == 3) {
      return 4;
    }
    if(cache[n] == 0) {
      cache[n] = getClimbCountOf(n-1, cache) + getClimbCountOf(n-2, cache) + getClimbCountOf(n-3, cache);
    }
    return cache[n];
  }

  public int getClimbCountOf(int n) {
    return getClimbCountOf(n, new int[n+1]);
  }

}
