package PACKAGE1;

public class Sample {
  private int a;
  int b;
  protected int z = 10;

  public Sample(int a,int b) {
    this.a = a;
    this.b = b;
  }

  public Sample() {
  
  }

  int helper(int a,int b) {
    return a+b+z;
  } 

  public String toString() {
    return a+" "+b;
  }
}
