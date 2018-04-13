package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Prob1260 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer stLine = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(stLine.nextToken());
    int m = Integer.parseInt(stLine.nextToken());
    int startV = Integer.parseInt(stLine.nextToken());
    
    List<Node> nodes = new ArrayList<>();
    for(int i = 0; i < n+1; i++) {
      nodes.add(new Node(i));
    }
    for(int i = 0; i < m; i++) {
      stLine = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(stLine.nextToken());
      int b = Integer.parseInt(stLine.nextToken());
      nodes.get(a).addNode(b);
      nodes.get(b).addNode(a);
    }
    
  }
  public static void DFS(List<Node> nodes, int startV) {
    Deque<Integer> stack = new ArrayDeque<Integer>();
    stack.push(startV);
    Node currentNode = nodes.get(startV);
    currentNode.visit();
    
    while(!stack.isEmpty()) {
      int current = stack.pop();
      for(int n : nodes.get(current).connected) {
        if(nodes.get(n).visited) {
          
        } else {
          stack.push(n);
          nodes.get(n).visit();
        }
      }
    }
    
    
  }

}

class Node {
  int v;
  List<Integer> connected;
  boolean visited;
  public Node(int v) {
    visited = false;
    this.v = v;
    connected = new ArrayList<Integer>();
  }
  
  void addNode(int v) {
    connected.add(v);
  }
  void visit() {
    this.visited = true;
  }
}
