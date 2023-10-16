public class L0002 {
  public static void main(String args[]) {
    System.out.println(power_2(2, 4));
  }

  public static int power_2(int x, int n) {
    if(n == 0) return 1;
    int power_half = power_2(x, n/2);
    // System.out.println(power_half);
    power_half *= power_half;
    if(n%2!=0) {
      power_half = x * power_half;
    }
    return power_half;
  }

  
}
