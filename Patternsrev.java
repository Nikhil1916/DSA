public  class Patternsrev{
  public static void main(String args[]) {
    int n = 5;
  //  for(int row=1;row<=n;row++) {
  //   for(int i=1;i<=row;i++) {
  //     System.out.print("*");
  //   }
  //   System.out.println();
  //  }
  int row = 1;
  int nStars = 1;
  int nSpace = n/2;
  while(row<=n) {
    int space = 1;
    while(space<=nSpace && row!=(n/2)+1) {
      System.out.print("  ");
      space++;
    }
    // System.out.print(nStars);
    int nSt = row==(n/2)+1 ? nStars : (nStars/2)+1;
    for(int stars = 1;stars<=nSt;stars++) {
        System.out.print("* ");
    }
    if(row>n/2) {
      // nSpace++;
      nStars-=2;
    } else {
      // nSpace--;
      nStars+=2;
    }
    System.out.println();
    row++;
  }
  }
}