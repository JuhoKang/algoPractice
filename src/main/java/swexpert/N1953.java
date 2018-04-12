package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N1953 {
  static int[][] input;
  static boolean[][] check;
  static boolean[][] checkTemp;
  static int n;
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseNum = Integer.parseInt(br.readLine());
    int counter = caseNum;

    while(counter-- > 0) {
      StringTokenizer stLine = new StringTokenizer(br.readLine());
      n = Integer.parseInt(stLine.nextToken());
      m = Integer.parseInt(stLine.nextToken());
      int r = Integer.parseInt(stLine.nextToken());
      int c = Integer.parseInt(stLine.nextToken());
      int l = Integer.parseInt(stLine.nextToken());
      input = new int[n][m];
      check = new boolean[n][m];
      for (int i = 0; i < n; i++) {
        stLine = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
          input[i][j] = Integer.parseInt(stLine.nextToken());
        }
      }
      check[r][c] = true;
      checkTemp = new boolean[n][m];
      checkTemp[r][c] = true;
      List<String> checkList = new ArrayList<String>();
      for (int i = 0; i < l - 1; i++) {
        for(int j = 0; j < n; j++) {
          for (int k = 0; k < m; k++) {
            if(check[j][k] == true) {
              checkList.add(""+j+" "+k);
            }
          }
        }
        for(String s : checkList) {
          String[] two = s.split(" ");
          checkBox(Integer.parseInt(two[0]), Integer.parseInt(two[1]));
        }

        checkTemp = check.clone();
        //System.out.println("check");
        //System.out.println(check);
        //System.out.println("checkTemp");
        //System.out.println(checkTemp);
        //printMap();
        //System.out.println("---------------");
        //printTempMap();
      }
      //System.out.println("end of one");

      int count = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if(check[i][j] == true) count++;
        }
      }
      System.out.println("#"+(caseNum - counter)+" "+count);
    }
  }

  public static void checkBox (int x, int y) {
    if(input[x][y] == 1) {
      checkUp(x, y);
      checkDown(x, y);
      checkLeft(x, y);
      checkRight(x, y);
    } else if(input[x][y] == 2) {
      checkUp(x, y);
      checkDown(x, y);
    } else if(input[x][y] == 3) {
      checkLeft(x, y);
      checkRight(x, y);
    } else if(input[x][y] == 4) {
      checkUp(x, y);
      checkRight(x, y);
    } else if(input[x][y] == 5) {
      checkDown(x, y);
      checkRight(x, y);
    } else if(input[x][y] == 6) {
      checkDown(x, y);
      checkLeft(x, y);
    } else if(input[x][y] == 7) {
      checkUp(x, y);
      checkLeft(x, y);
    }
  }

  public static void checkUp(int x, int y) {
    if(x - 1 >= 0) {
      if(!check[x - 1][y]) {
        if(input[x - 1][y] == 1 || input[x - 1][y] == 2 || input[x - 1][y] == 5 || input[x - 1][y] == 6) {
          //System.out.println("check : "+ (x-1) + ", "+y +"/// from : "+x+", "+y);
          check[x - 1][y] = true;
        }
      }
    }
  }
  public static void checkDown(int x, int y) {
    if(x + 1 < n) {
      if(!check[x + 1][y]) {
        if(input[x + 1][y] == 1 || input[x + 1][y] == 2 || input[x + 1][y] == 4 || input[x + 1][y] == 7) {
          //System.out.println("check : "+ (x+1) + ", "+y +"/// from : "+x+", "+y);
          check[x + 1][y] = true;
        }
      }
    }
  }
  public static void checkLeft(int x, int y) {
    if(y - 1 >= 0) {
      if(!check[x][y - 1]) {
        if(input[x][y - 1] == 1 || input[x][y - 1] == 3 || input[x][y - 1] == 4 || input[x][y - 1] == 5) {
          //System.out.println("check : "+ (x) + ", "+(y-1) +"/// from : "+x+", "+y);
          check[x][y - 1] = true;
        }
      }
    }
  }
  public static void checkRight(int x, int y) {
    if(y + 1 < m) {
      if(!check[x][y + 1]) {
        if(input[x][y + 1] == 1 || input[x][y + 1] == 3 || input[x][y + 1] == 6 || input[x][y + 1] == 7) {
          //System.out.println("check : "+ x + ", "+(y+1) +"/// from : "+x+", "+y);
          check[x][y + 1] = true;
        }
      }
    }
  }
  public static void printMap() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(check[i][j] == false) {
          System.out.print("0 ");
        } else {
          System.out.print("1 ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }
  public static void printTempMap() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(checkTemp[i][j] == false) {
          System.out.print("0 ");
        } else {
          System.out.print("1 ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }



}
