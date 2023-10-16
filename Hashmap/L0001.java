import java.util.HashMap;
public class L0001{
public static void main(String args[]) {
  HashMap<String,Integer> hm = new HashMap<>();
  System.out.println(hm);

  hm.put("India",100);

  hm.put("Australia",200);

  hm.put("London",200);

  hm.put("America",200);
  
  System.out.println(hm+" "+hm.size());

  System.out.println(hm+" "+hm.containsKey("India")+" "+hm.containsKey("USA"));

  System.out.println(hm.get("India")+" "+hm.get("USA")); 

  System.out.println(hm.keySet()); 

  for(String s:hm.keySet()) {
    System.out.println(s + " "+ hm.get(s));
  }
}
}