public class RL0009 {

  // queen chosses
  public static void printConfig_PlacingQueens_Permutation(int currentQueen,String [][]board){
    // logic

    if(currentQueen > board.length) {
      
    for(int i=0;i<board.length;i++) {
      for(int j=0;j<board.length;j++) {
        if(board[i][j] != null) {
          System.out.print(board[i][j]+"\t");
        } else {
          System.out.print("_\t");  
        }
      }
      System.out.println(); 
      System.out.println("-----------------------------------");
    }
      System.out.println();
    return;
    }


    for(int i=0;i<board.length;i++) {
      for(int j=0;j<board.length;j++) {
        if(board[i][j] == null) {
          board[i][j] = "q"+currentQueen;
          printConfig_PlacingQueens_Permutation(currentQueen+1, board);
          board[i][j] = null;
        }
      }
    }
  }
public static void main(String[] args) {
    int n = 4;
    
    // printConfig_PlacingQueens_Permutation(1,new String[n][n]);
    printConfig_PlacingQueens_Combination(1,new String[n][n],0,-1);
}

public static void printConfig_PlacingQueens_Combination(int currentQueen,String [][]board,int i , int j){
  // logic here

  if(currentQueen > board.length) {
      
    for(int row=0;row<board.length;row++) {
      for(int col=0;col<board.length;col++) {
        if(board[row][col] != null) {
          System.out.print(board[row][col]+"\t");
        } else {
          System.out.print("_\t");  
        }
      }
      System.out.println();
      System.out.println("-----------------------------------");
    }
    System.out.println();
    System.out.println();
     System.out.println();
     System.out.println();

    return;
    }

  for(int row = i;row<board.length;row++) {
    for(int col = (row == i) ? j+1 : 0;col<board.length;col++) {
      if(isSafe(board, row, col)) {
        board[row][col] = "q";
        printConfig_PlacingQueens_Combination(currentQueen+1,board,row,col);
        board[row][col] = null;
      }
    }
  }
}


// is safe fnc  to check whether we can place queen or not
public static Boolean isSafe(String board[][], int row, int col) {

    for(int r=0,c= col;r<board.length;r++) {
      if(board[r][c]!=null) {
        return false;
      }
    }

    for(int r=row,c=0;c<board.length;c++) {
      if(board[r][c]!=null) {
        return false;
      }
    }

    // right dia up
    for(int r=row,c=col;r>=0 && c<board.length;r--,c++) {
      if(board[r][c]!=null) {
        return false;
      }
    }

    // right dia down
    for(int r=row,c=col;r<board.length && c<board.length;r++,c++) {
      if(board[r][c]!=null) {
        return false;
      }
    }

    // left dia up
    for(int r=row,c=col;r>=0 && c>=0;r--,c--) {
      if(board[r][c]!=null) {
        return false;
      }
    }

    // left dia down
    for(int r=row,c=col;r<board.length && c>=0;r++,c--) {
        if(board[r][c]!=null) {
          return false;
        }
    }
    return true;
}
}