import java.util.Scanner;

public class RL0005 {
  // reactive
  public static int minMovesToClimbStairs(int currStair,int moves[]){
        // logic
      if(currStair == moves.length) {//valid case
        return 0;
      }

      if(currStair>moves.length || moves[currStair] == 0) {
        return Integer.MAX_VALUE;
      }

      int minMoves = Integer.MAX_VALUE;
      for(int i=1;i<=moves[currStair];i++) {
        int moveRecAns = minMovesToClimbStairs(currStair+i, moves);
        if(moveRecAns<minMoves) {
          minMoves = moveRecAns;
        }
      }
      return minMoves == Integer.MAX_VALUE ? minMoves : minMoves + 1;
    }



      public static int minMovesToClimbStairsProaActive(int currStair,int moves[]){
        // logic
      if(currStair == moves.length) {//valid case
        return 0;
      }

      int minMoves = Integer.MAX_VALUE;
      int moveRecAns = 0;
      for(int i=1;i<=moves[currStair];i++) {
        if(currStair+i<=moves.length) {
          if(currStair+i != moves.length && moves[currStair+i] == 0) {

          } else {
            moveRecAns = minMovesToClimbStairs(currStair+i, moves);
            if(moveRecAns<minMoves) {
              minMoves = moveRecAns;
            }
          }
        }
      }
      return minMoves == Integer.MAX_VALUE ? minMoves : minMoves + 1;
    }

    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);

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
        // int moves[] = {1,1,1,1};
        System.out.println(minMovesToClimbStairs(0,moves));
        System.out.println(minMovesToClimbStairsProaActive(0,moves));
    }
}
