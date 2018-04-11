package chap16;

import java.util.Random;

public class Prob20 {

  public static void main(String[] args) {
    int[] arr = new int[7];
    for(int i=0;i<700000;i++){
      arr[rand7()]++;
    }

    for (int n: arr) {
      System.out.println(n);
    }
  }


  public static int rand5() {
    Random r = new Random();
    return r.nextInt(5);
  }

  public static int rand7() {
    return (rand5()+rand5()+rand5()+rand5()+rand5()+rand5()+rand5()) % 7;
  }
}
