package chap16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob19 {

  public List<Integer> getPonds(int[][] geo, int n) {
    List<Integer> results = new ArrayList<>();
    int minusCounter = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int hit = 0;
        if (geo[i][j] == 0) {
          int count = 1;
          if (i > 0) {
            if (geo[i - 1][j] < 0) {
              hit = geo[i - 1][j];
              System.out.println("here1 hit:"+ hit+ "i : "+i+"/ j : "+j);
            }
          }
          if (j > 0) {
            if (geo[i][j - 1] < 0) {
              hit = geo[i][j - 1];
              System.out.println("here2 hit:"+ hit+ "i : "+i+"/ j : "+j);
            }
          }
          if (i > 0 && j > 0) {
            if (geo[i - 1][j - 1] < 0) {
              hit = geo[i - 1][j - 1];
              System.out.println("here2 hit:"+ hit+ "i : "+i+"/ j : "+j);
            }
          }
          if (i < n - 1) {
            if (geo[i + 1][j] < 0) {
              hit = geo[i + 1][j];
              System.out.println("here3 hit:"+ hit+ "i : "+i+"/ j : "+j);
            }
          }
          if (j < n - 1) {
            if (geo[i][j + 1] < 0) {
              hit = geo[i][j + 1];
              System.out.println("here4 hit:"+ hit+ "i : "+i+"/ j : "+j);
            }
          }
          if (i < n - 1 && j < n - 1) {
            if (geo[i + 1][j + 1] < 0) {
              hit = geo[i + 1][j + 1];
              System.out.println("here5 hit:"+ hit+ "i : "+i+"/ j : "+j);
            }
          }
          if (i > 0 && j < n - 1) {
            if (geo[i - 1][j + 1] < 0) {
              hit = geo[i - 1][j + 1];
              System.out.println("here6 hit:"+ hit+ "i : "+i+"/ j : "+j);
            }
          }
          if (j > 0 && i < n - 1) {
            if (geo[i + 1][j - 1] < 0) {
              hit = geo[i + 1][j - 1];
              System.out.println("here7 hit:"+ hit+ "i : "+i+"/ j : "+j);
            }
          }

          if (hit < 0) {
            System.out.println("hit:"+ hit+ "i : "+i+"/ j : "+j);
            geo[i][j] = hit;
          } else {
            System.out.println("not hit/ i : " + i + "/ j : " + j);
            geo[i][j] = minusCounter;
            minusCounter--;
          }
        }
      }
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(geo[i][j] + " ");
        if (map.containsKey(geo[i][j])) {
          map.put(geo[i][j], map.get(geo[i][j]) + 1);
        } else {
          map.put(geo[i][j], 1);
        }
      }
      System.out.println();
    }

    for(int i = -1; i > minusCounter; i--) {
      results.add(map.get(i));
    }

    return results;
  }
}
