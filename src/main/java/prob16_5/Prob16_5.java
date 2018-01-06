package prob16_5;

public class Prob16_5 {

  public static void main(String[] args) {

  }

  public long createFactorial(long num) {
    long result = 1;
    for(long i = num; i > 1; i--) {
      result *= num;
      num--;
    }
    return result;
  }

  public int getZeroCount(long num) {
    int count = 0;
    while(num % 10 == 0) {
      count++;
      num /= 10;
    }
    return count;
  }
}
