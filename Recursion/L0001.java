public class L0001 {

  public static void main(String args[]) {
    // printDec(5);
    // printInc(5);
    // printIncDec2(8);
    System.out.println(powerOfNum(2,5));
  }
  public static void printDec(int n) {
    if(n==1) return;
    System.out.println(n);
    printDec(n-1);
  }

  public static void printInc(int n) {
    if(n==0) return;
    printInc(n-1);
    System.out.println(n);
  }

  public static void printIncDec2(int n) {
    if(n==1) {
      System.out.println(1);
      return;
    }
    if(n%2!=0)
    System.out.println(n);
    printIncDec2(n-1);
    if(n%2==0)
    System.out.println(n);
  }

  public static int powerOfNum(int x,int n) {
    if(n==1) return x;
   return  x * powerOfNum(x, n-1);
  }
}

