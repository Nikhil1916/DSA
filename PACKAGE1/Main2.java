package PACKAGE1;

public class Main2 extends Sample {
  public static void main(String args[]) {
    Sample s = new Sample(1,2);
    System.out.println(s.b);
    // System.out.print(s.a); as a is private variable
  }
}
