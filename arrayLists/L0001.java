import java.util.ArrayList;
public class L0001 {
  public static void main(String args[]) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(10);
    arr.add(20);
    arr.add(30);
    arr.add(40);
    arr.add(50);
    // System.out.println(arr);
    // for(int i=0;i<=arr.size()-1;i++) {
    //   System.out.println(i+" => "+arr.get(i));
    // }
    arr.set(1,100);
    arr.add(1,200);
    arr.add(6,500);
    System.out.println(arr);
    String s = "abcde";
    System.out.println(s.substring(5,6));
  }
}