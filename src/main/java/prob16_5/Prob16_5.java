package prob16_5;

import java.util.Scanner;

public class Prob16_5 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    System.out.println(getZeroCount(createFactorial(number)));
  }

  public static long createFactorial(long num) {
    long result = 1;
    for(long i = num; i > 1; i--) {
      result *= num;
      num--;
    }
    return result;
  }

  public static int getZeroCount(long num) {
    int count = 0;
    while(num % 10 == 0) {
      count++;
      num /= 10;
    }
    return count;
  }
}
