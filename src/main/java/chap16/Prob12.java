package chap16;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Prob12 {

  public static void main(String[] args) {
  }

  private Map<String, Integer> tagMap = new HashMap<String, Integer>();

  public Prob12() {
    tagMap.put("family", 1);
    tagMap.put("person", 2);
    tagMap.put("firstName", 3);
    tagMap.put("lastName", 4);
    tagMap.put("state", 5);
  }


  public String solve(String input) {
    Deque<String> stack = new ArrayDeque<String>();
    String modifiedString = input.replace(">", " ");
    String[] chunks = modifiedString.split("[ \t\n]");
    String result = "";
    for(String c : chunks) {
      if(c.startsWith("<")) {
        stack.add(c);
        result = result + tagMap.get(c);
      }
      System.out.println(c);
    }

    return result;
  }
}
