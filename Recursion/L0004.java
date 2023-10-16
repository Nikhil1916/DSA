public class L0004 {
  public static void main(String args[]) {
    int mat[][] = new int[3][3];
    mat[1][2] = 1;
    mat[2][0] = 1;
    // int count = findMatrixPathCountObstruction(0,0,2,2,mat); 
    // int count = waysToClimbStairs(0,4);
    int count = countWaysInSimpleMatrix(0,0,2,2);
    System.out.println(count);
  }

  public static int findMatrixPathCountObstruction(int sr, int sc, int dr, int dc,int mat[][]) {
    if( mat[0][0] == 1 || mat[dr][dc] == 1) {
      return 0;
    }    
    return findMatrixPathCountObstructionHelper(0,0,2,2,mat);
  }

  public static int findMatrixPathCountObstructionHelper(int sr, int sc, int dr, int dc,int mat[][]) {
    if(sr > dr || sc > dc || mat[sr][sc] == 1) {
      return  0;
    }
    if(sr == sc && dr == sc) {
      return 1;
    }
    int hVal = findMatrixPathCountObstructionHelper(sr,sc+1,dr,dc,mat);
    int dVal = findMatrixPathCountObstructionHelper(sr+1,sc+1,dr,dc,mat);
    int vVal = findMatrixPathCountObstructionHelper(sr+1,sc,dr,dc,mat);
    return hVal + dVal + vVal;
  }

  public static int waysToClimbStairs(int curr,int n) {
    if(curr > n) return 0;
    if(n == curr) {
      return 1;
    }
    int oneStep = waysToClimbStairs(curr+1, n);
    int twoStep = waysToClimbStairs(curr+2, n);
    return oneStep + twoStep; 
  }

  public static int countWaysInSimpleMatrix(int sr, int sc, int dr, int dc) {
    if(sr > dr || sc > dc) {
      return  0;
    }
    if(sr == sc && dr == sc) {
      return 1;
    }
    int hVal = countWaysInSimpleMatrix(sr,sc+1,dr,dc);
    int vVal = countWaysInSimpleMatrix(sr+1,sc,dr,dc);
    return hVal + vVal;
  }
}
