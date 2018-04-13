package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4014 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseNum = Integer.parseInt(br.readLine());
    int counter = caseNum;
    int[][] input;
    while (counter-- > 0) {
      StringTokenizer stLine = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(stLine.nextToken());
      int X = Integer.parseInt(stLine.nextToken());
      input = new int[n][n];
      int count = 0;
      for (int i = 0; i < n; i++) {
        stLine = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          input[i][j] = Integer.parseInt(stLine.nextToken());
        }
      }

      for (int i = 0; i < n; i++) {
        if (canRamp(input[i], X))
          count++;
      }
      for (int i = 0; i < n; i++) {
        int[] temp = new int[n];
        for (int j = 0; j < n; j++) {
          temp[j] = input[j][i];
        }
        if (canRamp(temp, X))
          count++;
      }

      System.out.println("#" + (caseNum - counter) + " " + count);
    }
  }

  private static boolean canRamp(int[] tiles, int X) {
    boolean[] hasRamp = new boolean[tiles.length];

    for (int i = 0; i < tiles.length; i++) {
      if ((i + 1) < tiles.length) {
        if (tiles[i + 1] == tiles[i] - 1) {
          for (int j = 0; j < X; j++) {
            if (i + j + 1 < tiles.length) {
              if (tiles[i + 1] != tiles[i + j + 1]) {
                return false;
              } else {
                if (hasRamp[i + j + 1]) {
                  return false;
                } else {
                  hasRamp[i + j + 1] = true;
                }
              }
            } else {
              return false;
            }
          }
        }
        if (tiles[i + 1] == tiles[i] + 1) {
          for (int j = 0; j < X; j++) {
            if (i - j >= 0) {
              if (tiles[i] != tiles[i - j]) {
                return false;
              } else {
                if (hasRamp[i - j]) {
                  return false;
                } else {
                  hasRamp[i - j] = true;
                }
              }
            } else {
              return false;
            }
          }
        }
        if (tiles[i + 1] > tiles[i] + 1) {
          return false;
        }
        if (tiles[i + 1] < tiles[i] - 1) {
          return false;
        }
      }
    }
    return true;
  }

}
