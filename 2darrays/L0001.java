public class L0001 {
  public static void main(String args[]) {
   int mat[][] = new int[4][2];
   int count = 1;
   for(int i=0;i<mat.length;i++) {
    for(int j=0;j<mat[0].length;j++) {
      mat[i][j] = count++;
    }
   }

   for(int j=0;j<mat[0].length;j++) {
    for(int i=0;i<mat.length;i++) {
       System.out.println(i+" "+j+" ->" + mat[i][j]);
    }
   }
   System.out.println((9)/2);

  }
}
