package prob16_5;

import java.util.Scanner;

public class Prob16_5 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    //this is possible because always 2count > 5count
    System.out.println(countFiveCountUnder(number));
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

  public static int countFiveCountUnder(int num) {
    int count = 0;
    for(int i = num; i > 1; i--) {
      if(i%5 == 0) {
        count++;
      }
    }
    return count;
  }
}
