package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1949 {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int caseNum = Integer.parseInt(br.readLine());
    int bigCaseNum = caseNum;
    while (caseNum-- > 0) {
      StringTokenizer stInfo = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(stInfo.nextToken());
      int k = Integer.parseInt(stInfo.nextToken());
      int[][] path = new int[n][n];
      boolean[][] checker = new boolean[n][n];
      int maxHeight = 0;
      for (int i = 0; i < n; i++) {
        StringTokenizer stInputLine = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          int item = Integer.parseInt(stInputLine.nextToken());
          if (item > maxHeight) {
            maxHeight = item;
          }
          path[i][j] = item;
        }
      }

      int max = 0;
      int partRes = 0;
      //System.out.println("maxHeight : " + maxHeight);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (path[i][j] == maxHeight) {
            checker = new boolean[n][n];
            partRes = navigate(path, checker, path[i][j], i, j, n, k, true);
            System.out.println("partRes : " + partRes);
            if (partRes > max) {
              max = partRes;
            }
          }
        }
      }

      System.out.println("#" + (bigCaseNum - caseNum) + " " + max);
    }
  }

  public static int navigate(int[][] path, boolean[][] checker, int val, int x, int y, int n, int k,
      boolean canSub) {
    checker[x][y] = true;
    int max = 0;
    int result = 0;
    if (x - 1 >= 0) {
      //if (!checker[x - 1][y]) {
      if (val > path[x - 1][y]) {
        result = navigate(path, checker, path[x - 1][y], x - 1, y, n, k, canSub);
      } else {
        if (canSub) {
          int part = 0;
          for (int i = 1; i <= k; i++) {
            if (val > path[x - 1][y] - i) {
              part = navigate(path, checker, path[x - 1][y] - i, x - 1, y, n, k, false);
              //System.out.println("part of inside x - 1 : "  + i +" //"+ part);
            }
            if (part > result) {
              result = part;
            }
          }
        }
        //}
        if (result > max) {
          max = result;
        }
      }
    }
    result = 0;
    if (x + 1 < n) {
      //if (!checker[x + 1][y]) {
      if (val > path[x + 1][y]) {
        result = navigate(path, checker, path[x + 1][y], x + 1, y, n, k, canSub);
      } else {
        if (canSub) {
          int part = 0;
          for (int i = 1; i <= k; i++) {
            if (val > path[x + 1][y] - i) {
              part = navigate(path, checker, path[x + 1][y] - i, x + 1, y, n, k, false);
              //System.out.println("part of inside x + 1 : " + i +" //" + part);
            }
            if (part > result) {
              result = part;
            }
          }
        }
      }
      //}
      if (result > max) {
        max = result;
      }
    }
    result = 0;
    if (y - 1 >= 0) {
      //if (!checker[x][y - 1]) {
      if (val > path[x][y - 1]) {
        result = navigate(path, checker, path[x][y - 1], x, y - 1, n, k, canSub);
      } else {
        if (canSub) {
          int part = 0;
          for (int i = 1; i <= k; i++) {
            if (val > path[x][y - 1] - i) {
              part = navigate(path, checker, path[x][y - 1] - i, x, y - 1, n, k, false);
              //System.out.println("part of inside y - 1 : " + i +" //"+part);
            }
            if (part > result) {
              result = part;
            }
          }
        }
      }
      //}
      if (result > max) {
        max = result;
      }
    }
    result = 0;
    if (y + 1 < n) {
      //if (!checker[x][y + 1]) {
      if (val > path[x][y + 1]) {
        result = navigate(path, checker, path[x][y + 1], x, y + 1, n, k, canSub);
      } else {
        if (canSub) {
          int part = 0;
          for (int i = 1; i <= k; i++) {
            if (val > path[x][y + 1] - i) {
              part = navigate(path, checker, path[x][y + 1] - i, x, y + 1, n, k, false);
              //System.out.println("part of inside y + 1 : "  + i +" //"+ part);
            }
            if (part > result) {
              result = part;
            }
          }
        }
      }
      //}
      if (result > max) {
        max = result;
      }
    }
    return max + 1;
  }

}
