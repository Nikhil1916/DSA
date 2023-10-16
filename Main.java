// import java.util.*;
public class Main{
  public static void main(String args[]) {
    // System.out.println("Hi");


    // System.out.println(15+2);
    // System.out.println(15-2);
    // System.out.println(15*2);
    // System.out.println(15/2);
    // System.out.println(15%2);

    // System.out.println(15<2);
    // System.out.println(15>2);
    // System.out.println(15!=2);
    // System.out.println(15==2);
    // System.out.println(15>=2);

    // int var1 = 35;
    // int var2 = 20;
    // int res = var1 + var2;
    // String msg1 = "number is big";
    // String msg2 = "number is small";
    // System.out.println(res);
    // if(var1>var2) {
    //   System.out.println(msg1);
    // } else if(var1<var2) System.out.println(msg2);
      int a = 40;
      int b = 20;
      int c = 30;

      if(a>b) {
        if(c>a) {
          System.out.println(c);
        } else {
          System.out.println(a);
        }
      } else if(b>c) {
        System.out.println(b);
      } else {
        System.out.println(c);
      }

      int greatest = a;
      if(greatest<b) {
        greatest = b;
      } 
      if(greatest <c){
        greatest = c;
      }
      System.out.println(greatest);
  }
}