import java.util.Scanner;
public class RL0004 {
  public static void main(String args[]) {
    System.out.println(NumberWaysToClimbStairs(4));
    System.out.println(NumberWaysToClimbStairsProactive(4));
    Scanner sc = new Scanner(System.in);
    numOfWaysToClimbStairsWithVariableJump_Helper(sc);
  }

  // reactive
  public static int NumberWaysToClimbStairs(int n) {
    if(n<0) {
      return 0;
    }

    if(n == 0) {
      return 1;
    }

    int jump1Ways = NumberWaysToClimbStairs(n-1);
    int jump2Ways = NumberWaysToClimbStairs(n-2);
    int jump3Ways = NumberWaysToClimbStairs(n-3);

    return jump1Ways + jump2Ways + jump3Ways;
    
  }

// proactive  
public static int NumberWaysToClimbStairsProactive(int n) {
    if(n == 0) {
      return 1;
    }

    int ans = 0;
    if(n-1>=0) {
      ans+= NumberWaysToClimbStairsProactive(n-1);
    }
    if(n-2>=0) {
      ans+= NumberWaysToClimbStairsProactive(n-2);
    }
    if(n-3>=0) {
      ans+= NumberWaysToClimbStairsProactive(n-3);
    }
    return ans;
  }


    // reactive 
    public static int numOfWaysToClimbStairsWithVariableJumpReactive(int stNum , int moves[]){
        // logic for this function
        if(stNum == moves.length) {
          return 1;
        }

        if(stNum>moves.length || moves[stNum] == 0) {
          return 0;
        }

        int ans = 0;

        for(int i=1;i<=moves[stNum];i++) {
          ans+=numOfWaysToClimbStairsWithVariableJumpReactive(stNum+i,moves);
        }

        return ans;
    }


    public static int numOfWaysToClimbStairsWithVariableJumpProactive(int stNum , int moves[]){
        // logic for this function
        if(stNum == moves.length) {
          return 1;
        }

        int ans = 0;
        for(int i=1;i<=moves[stNum];i++) {
          if(stNum+i<=moves.length) {
            if((stNum+i!=moves.length && moves[stNum+i] == 0)) {

            } else {
              ans+=numOfWaysToClimbStairsWithVariableJumpProactive(stNum+i,moves);
            }
          }
        }

        return ans;
    }

    public static void numOfWaysToClimbStairsWithVariableJump_Helper(Scanner scn){
        // int numOfStairs = scn.nextInt();

        // int moves[] = new int[numOfStairs];

        // for(int i = 0 ; i < numOfStairs ; i++){
        //     moves[i] = scn.nextInt();
        // }
        /*
        Sample Input :
        10
        3 3 0 2 1 2 4 2 0 0
         */
        int moves[] = {3,3,0,2,1,2,4,2,0,0};
        System.out.println(numOfWaysToClimbStairsWithVariableJumpReactive(0,moves) + " ans");
        System.out.println(numOfWaysToClimbStairsWithVariableJumpProactive(0,moves) + " ans");
    }
  }