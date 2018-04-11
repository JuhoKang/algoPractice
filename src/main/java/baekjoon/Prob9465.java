package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob9465 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));

    int caseNum = Integer.parseInt(br.readLine());
    while (caseNum-- > 0) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer stLine = new StringTokenizer(br.readLine());
      int[][] data = new int[2][n + 2];
      for (int i = 1; i < n + 1; i++) {
        data[0][i] = Integer.parseInt(stLine.nextToken());
      }
      stLine = new StringTokenizer(br.readLine());
      for (int i = 1; i < n + 1; i++) {
        data[1][i] = Integer.parseInt(stLine.nextToken());
      }
      System.out.println(getMaxPoint(data, n));
    }
  }

  public static int getMaxPoint(int[][] data, int n) {
    int[][] cache = new int[2][n + 2];

    for (int i = 1; i < n + 1; i++) {
      int a = cache[0][i - 1] - data[0][i - 1] + data[0][i];
      int b = cache[1][i - 1] + data[0][i];
      if (a > b) {
        cache[0][i] = a;
      } else {
        cache[0][i] = b;
      }
      a = cache[0][i-1] + data[1][i];
      b = cache[1][i-1] - data[1][i - 1] + data[1][i];
      if (a > b) {
        cache[1][i] = a;
      } else {
        cache[1][i] = b;
      }
    }

    /*System.out.println("after calc");
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < n+1; j++) {
        System.out.print(cache[i][j] + " / ");
      }
      System.out.println();
    }*/

    if(cache[0][n] > cache[1][n]) {
      return cache[0][n];
    } else {
      return cache[1][n];
    }
  }


}
