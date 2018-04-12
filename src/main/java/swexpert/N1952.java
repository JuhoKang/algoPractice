package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//수영장
public class N1952 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseNum = Integer.parseInt(br.readLine());
    int counter = caseNum;
    int[] a = new int[14];
    while (counter-- > 0) {
      StringTokenizer stLine = new StringTokenizer(br.readLine());
      int day = Integer.parseInt(stLine.nextToken());
      int month = Integer.parseInt(stLine.nextToken());
      int tMonth = Integer.parseInt(stLine.nextToken());
      int year = Integer.parseInt(stLine.nextToken());
      stLine = new StringTokenizer(br.readLine());
      int sum = 0;
      for (int i = 0; i < 12; i++) {
        a[i] = Integer.parseInt(stLine.nextToken()) * day;
      }
      for (int i = 0; i < 12; i++) {
        if (a[i] > month) {
          a[i] = month;
        }
      }
      for (int i = 0; i < 12; i++) {
        sum += a[i];
      }

      int[][] tmArr = new int[2][12];
      for (int i = 0; i < 12; i++) {
        if (i - 3 >= 0) {
          int min = Integer.MAX_VALUE;
          int bef3Plus = tmArr[1][i - 3] - a[i] - a[i + 1] - a[i + 2] + tMonth;
          if (min > bef3Plus) {
            min = bef3Plus;
          }
          int bef2Plus = tmArr[0][i - 2] - a[i] - a[i + 1] - a[i + 2] + tMonth;
          if (min > bef2Plus) {
            min = bef2Plus;
          }
          int bef1Plus = tmArr[0][i - 1] - a[i] - a[i + 1] - a[i + 2] + tMonth;
          if (min > bef1Plus) {
            min = bef1Plus;
          }
          tmArr[1][i] = min;

          min = Integer.MAX_VALUE;
          if (min > tmArr[0][i - 3]) {
            min = tmArr[0][i - 3];
          }
          if (min > tmArr[0][i - 2]) {
            min = tmArr[0][i - 2];
          }
          if (min > tmArr[0][i - 1]) {
            min = tmArr[0][i - 1];
          }
          tmArr[0][i] = min;

        } else {
          tmArr[1][i] = sum - a[i] - a[i + 1] - a[i + 2] + tMonth;
          tmArr[0][i] = sum;
        }
      }

      int min = Integer.MAX_VALUE;
      for(int i = 0; i < 2; i ++) {
        for(int j = 0; j < 12; j++) {
          if(min > tmArr[i][j]) {
            min = tmArr[i][j];
          }
        }
      }
      System.out.println("#"+(caseNum-counter)+" "+(min < year ? min : year));
    }

  }

}
