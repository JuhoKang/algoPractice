package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2178 {
  static int n;
  static int m;
  static boolean[][] maze;
  //static List<Integer> resultList = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stLine = new StringTokenizer(br.readLine());

    n = Integer.parseInt(stLine.nextToken());
    m = Integer.parseInt(stLine.nextToken());
    maze = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      char[] temp = br.readLine().toCharArray();
      for (int j = 0; j < m; j++) {
        if (temp[j] == '1') {
          maze[i][j] = true;
        } else {
          maze[i][j] = false;
        }
      }
    }
    /*
     * for(int i = 0; i < n; i++) { for(int j = 0; j < m; j++) { System.out.print(maze[i][j]+" "); }
     * System.out.println(); }
     */
    System.out.println(solveMaze(new boolean[n][m], 0, 0));
    // System.out.println("===============");
    // for(int i : resultList) {
    // System.out.println(i);
    // }
  }

  static int solveMaze(boolean[][] visited, int x, int y) {
    visited[x][y] = true;
    /*
     * System.out.println(x+"--------------------"+y); for(int i = 0; i < n; i++) { for(int j = 0; j
     * < m; j++) { System.out.print(visited[i][j]+" "); } System.out.println(); }
     * System.out.println(x+"--------------------"+y);
     */
//    if ((x == n - 1) && (y == m - 1)) {
//      int count = 0;
//      for (int i = 0; i < n; i++) {
//        for (int j = 0; j < m; j++) {
//          if (visited[i][j] == true) {
//            count++;
//          }
//        }
//      }
//      //resultList.add(count);
//      return count;
//    }
    if ((x == n - 1) && (y == m - 1)) {
      return 1;
    }
    int visitCount = 0;
    int[] results = new int[4];

    if (y + 1 < m) {
      if (maze[x][y + 1] && !visited[x][y + 1]) {
        // System.out.println("x:"+x+"/y:"+y+"go right");
        results[3] = solveMaze(cloneBA(visited), x, y + 1);
        visitCount++;
      } else {
        results[3] = -1;
      }
    } else {
      results[3] = -1;
    }
    // System.out.println(x+"--------------------"+y);
    // for(int i = 0; i < n; i++) {
    // for(int j = 0; j < m; j++) {
    // System.out.print(visited[i][j]+" ");
    // }
    // System.out.println();
    // }
    // System.out.println(x+"--------------------"+y);
    if (x + 1 < n) {
      if (maze[x + 1][y] && !visited[x + 1][y]) {
        // System.out.println("x:"+x+"/y:"+y+"go down");
        results[1] = solveMaze(cloneBA(visited), x + 1, y);
        visitCount++;
      } else {
        results[1] = -1;
      }
    } else {
      results[1] = -1;
    }

    if (x - 1 >= 0) {
      if (maze[x - 1][y] && !visited[x - 1][y]) {
        // System.out.println("x:"+x+"/y:"+y+"go up");
        results[0] = solveMaze(cloneBA(visited), x - 1, y);
        visitCount++;
      } else {
        results[0] = -1;
      }
    } else {
      results[0] = -1;
    }
    if (y - 1 >= 0) {
      if (maze[x][y - 1] && !visited[x][y - 1]) {
        // System.out.println("x:"+x+"/y:"+y+"go left");
        results[2] = solveMaze(cloneBA(visited), x, y - 1);
        visitCount++;
      } else {
        results[2] = -1;
      }
    } else {
      results[2] = -1;
    }

    if (visitCount == 0) {
      // System.out.println("x:"+x+"/y:"+y+"out of visiting");
      return 50000;
    }

    int min = Integer.MAX_VALUE;

    // System.out.println("x : "+x+" / y : "+y);
    for (int i = 0; i < 4; i++) {
      // System.out.println(results[i]);
      if (results[i] > 0 && results[i] < min) {
        min = results[i];
      }
    }
    // System.out.println("------------------");

    // System.out.println("x:"+x+"/y:"+y+"returning min");
    return min + 1;
  }

  static boolean[][] cloneBA(boolean[][] input) {
    boolean[][] anotherOne = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        anotherOne[i][j] = input[i][j];
      }
    }
    return anotherOne;
  }
}
