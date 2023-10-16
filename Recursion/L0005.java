public class L0005 {
  public static void main(String args[]) {
    int mat[][] = new int[3][3];
    mat[1][2] = 1;
    mat[2][0] = 1;
    boolean visited[][] = new boolean[3][3];
    System.out.println(mazePathWithAllDirectionsAndBomb(0,0,mat,visited));
  }
  // backtracing
  public static int mazePathWithAllDirectionsAndBomb(int sr,int sc,int maze[][],boolean visited[][]) {
    if(sr < 0 || sc < 0 || sr >= maze.length || sc>=maze[0].length || maze[sr][sc] == 1 || visited[sr][sc] == true) {
      return 0;
    }
    // System.out.println(sr+" "+sc);

    if(sr == maze.length - 1 && maze[0].length-1 == sc) {
      return 1;
    }
    visited[sr][sc] = true;
    int tCall = mazePathWithAllDirectionsAndBomb(sr-1, sc, maze, visited);
    int lCall = mazePathWithAllDirectionsAndBomb(sr, sc-1, maze, visited);
    int dCall = mazePathWithAllDirectionsAndBomb(sr+1, sc, maze, visited);
    int rCall = mazePathWithAllDirectionsAndBomb(sr, sc+1, maze, visited);
    visited[sr][sc] = false;
    return tCall + lCall + rCall + dCall;
  } 
}
