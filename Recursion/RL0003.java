import java.util.ArrayList;
public class RL0003 {

  public static void main(String args[]) {
    System.out.println(climbStairsProactive(4));
    System.out.println(climbStairsReactive(4));
    printStairsProactive(4,"");
    printStairsReactive(4,"");
  }

  public static ArrayList<String> climbStairsProactive(int n) {
    ArrayList<String> ans = new ArrayList<>();
    
    if(n == 0) {
      ans.add("");
      return ans;
    }

    if(n-1 >=0) {
      ArrayList<String> oneJump = climbStairsProactive(n-1);
      if(oneJump.size() > 0) {
        for(String str:oneJump) {
          ans.add('1' + str);
        }
      }
    }
     
    if(n-2>=0) {
      ArrayList<String> twoJump = climbStairsProactive(n-2);
      if(twoJump.size()>0) {
        for(String str: twoJump) {
          ans.add('2'+str);
        }
      } 
    }

    if(n-3>=0) {
      ArrayList<String> threeJump = climbStairsProactive(n-3);
      if(threeJump.size()>0) {
        for(String str:threeJump) {
          ans.add('3'+str);
        }
      } 
    }
    return ans;
  }
  

public static ArrayList<String> climbStairsReactive(int n) {
    ArrayList<String> ans = new ArrayList<>();
    if(n<0) {
      return ans;
    }
    if(n == 0) {
      ans.add("");
      return ans;
    }

      ArrayList<String> oneJump = climbStairsReactive(n-1);
      if(oneJump.size() > 0) {
        for(String str:oneJump) {
          ans.add('1' + str);
        }
      }
     
      ArrayList<String> twoJump = climbStairsReactive(n-2);
      if(twoJump.size()>0) {
        for(String str: twoJump) {
          ans.add('2'+str);
        }
      } 

      ArrayList<String> threeJump = climbStairsReactive(n-3);
      if(threeJump.size()>0) {
        for(String str:threeJump) {
          ans.add('3'+str);
        }
      } 
    return ans;
  }
  


public static void printStairsReactive(int n, String asf) {
  if(n<0) {
    return;
  }

  if(n == 0) {
    System.out.println(asf);
    return;
  }

  printStairsReactive(n-1,asf+"1");
  printStairsReactive(n-2,asf+"2");
  printStairsReactive(n-3,asf+"3");
  
}

public static void printStairsProactive(int n, String asf) {

  if(n == 0) {
    System.out.println(asf);
    return;
  }

  if(n-1>=0) {
    printStairsReactive(n-1,asf+"1");
  }

  if(n-2>=0) {
    printStairsReactive(n-2,asf+"2");
  }

  if(n-3>=0) {
    printStairsReactive(n-3,asf+"3");
  }
  
}
}

