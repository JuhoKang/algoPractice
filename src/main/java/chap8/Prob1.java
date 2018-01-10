package chap8;

import java.util.Scanner;

public class Prob1 {

  public static void main(String[] args) {
    Prob1 app = new Prob1();
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    System.out.println(app.getClimbCountOf(input));
  }

  public Prob1() {
  }

  public long getClimbCountOf(long n) {
    if (n < 1) {
      return 0;
    } else if (n < 3) {
      return n;
    } else if (n == 3) {
      return 4;
    }

    int result = 0;
    int a = 1;
    int b = 2;
    int c = 4;
    for (int i = 0; i < n - 3; i++) {
      int temp1 = c;
      c = a + b + c;
      a = b;
      b = temp1;
    }

    return c;
  }

}
