package chap16;

public class Prob6Element implements Comparable<Prob6Element>{

  private final int arrId;
  private final int num;

  public Prob6Element(int arrId, int num) {
    this.arrId = arrId;
    this.num = num;
  }

  public int getArrId() {
    return arrId;
  }
  public int getNum() {
    return num;
  }

  public int compareTo(Prob6Element o) {
    if(this.num > o.num) {
      return 1;
    } else if (this.num < o.num) {
      return -1;
    } else {
      return 0;
    }
  }

  @Override
  public String toString() {
    return "Prob6Element{" +
        "arrId=" + arrId +
        ", num=" + num +
        '}';
  }
}
