package PACKAGE2;
import PACKAGE1.Sample;

public class Main1 extends Sample {
  public static void main(String args[]) {
    Sample s = new Sample(1,2);
    // System.out.println(s.b); default variable is not accesible outside package
    // System.out.print(s.a); as a is private variable


    // to use protected we need to create instance of the class which is taking from parent as main1 class will have the inherited properties
    Main1 m = new Main1();
    System.out.println(m.z);
    // System.out.println(s.)
  }
}
