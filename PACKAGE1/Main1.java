package PACKAGE1;

class Copy {
  private int var;
}


public class Main1 {

  public static void main(String args[]) {
    Sample s = new Sample();
    System.out.println(s.helper(10, 20));
    // Copy c = new Copy();
    // System.out.println(c.var); cannot access as var is private 

  }
  
}
