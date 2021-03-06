package chap16;

import java.util.Scanner;

public class Prob5 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    //this is possible because always 2count > 5count
    System.out.println(countFiveCountUnder(number));
  }

  public static long createFactorial(long num) {
    long result = 1;
    for (long i = num; i > 1; i--) {
      result *= num;
      num--;
    }
    return result;
  }

  public static int getZeroCount(long num) {
    int count = 0;
    while (num % 10 == 0) {
      count++;
      num /= 10;
    }
    return count;
  }

  public static int countFiveCountUnder(int num) {
    int count = 0;
    num -= num % 5;
    while (num / 5 > 0) {
      count += howManyFiveDivides(num);
      num -= 5;
    }
    return count;
  }

  public static int howManyFiveDivides(int num) {
    int count = 0;
    while (num / 5 > 0) {
      if (num % 5 == 0) {
        count++;
      }
      num /= 5;
    }
    return count;
  }
}
