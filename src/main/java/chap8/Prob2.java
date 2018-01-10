package chap8;

public class Prob2 {

  public int calcPaths(int[][] path, int r, int c) {
    int[][] results = new int[r][c];
    int result = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if(path[i][j] == 0) {
          results[i][j] = 0;
        } else {
          if(j > 0 && i > 0) {
            results[i][j] += results[i][j-1];
            results[i][j] += results[i-1][j];
          } else {
            if(i == 0 && j == 0) {
              results[i][j] = path[i][j];
            } else if(i == 0 && j > 0) {
              results[i][j] = results[i][j-1];
            } else if(i > 0 && j == 0) {
              results[i][j] = results[i-1][j];
            }
          }
        }

      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        System.out.print(results[i][j]+" ");
      }
      System.out.println();
    }


    return results[r-1][c-1];
  }

}
