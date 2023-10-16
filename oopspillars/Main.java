// package oopspillarsEncapsulation;
// package oopspillars;
class Encapsulation { //rectangle class ex just named class encapsulation for learning
  private int l;
  private int w;

  Encapsulation(int len, int wid) {
    l = len;
    w = wid;
  }

  public int getLen() {
    return l;
  } 

  public void setLen(int len) {
    l = len;
  }
  
  public void setWid(int wid) {
    w = wid;
  }

  public int getWidth() {
    return w;
  } 

}

public class Main {
  public static void main(String args[]) {
    Encapsulation en = new Encapsulation(10,20);
    System.out.println(en.getWidth());
  }
}
