import java.util.HashSet;
public class L0001 {
  public static void main(String args[]) {
    HashSet<Integer> hs = new HashSet<>();
    System.out.println(hs.size());
    System.out.println(hs);
    hs.add(10);
    hs.add(20);
    hs.add(30);
    System.out.println(hs);
    hs.add(40);
    hs.add(30);
    hs.remove(200);
    hs.remove(10);
    System.out.println(hs);
    for(Integer vl : hs){
      System.out.print(vl+" -> ");
    }
    System.out.println(hs.contains(20));

  }
}
