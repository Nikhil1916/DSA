public class Patterns {
  public static void main(String args[]) {
    // pattern2(5);
    // pattern3(6);
    // pattern5(6);
    // pattern6(5);
    // pattern7(4);
    // pattern8(7);
    // pattern9(7);
    // pattern9(8);
    // pattern10(5);
    // pattern11(5);
    // pattern12(5);
    // pattern13(5);
    // pattern14(7);
    // pattern15(5);
    // pattern16(7);
    // pattern17(5);
    // pattern18(7);
    // pattern19(5);
    // pattern20(9);
    //  pattern21(7);
    // pattern22(7);
    // pattern22(5);
    // pattern23(5)
    // diamondChange(7);
    // printArrow1(7);
    // printArrow2(7);
    // hollowDiamond(7);
    // diamondFrame(5);
    diamondFrame2(5);
  }

  public static void pattern2(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i<=(n-line+1))
        System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void pattern3(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i>(n-line)) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void pattern4(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i>=line){
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }
  
  public static void pattern5(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i==line) {
          System.out.print("* ");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void pattern6(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i+line==(n+1)) {
          System.out.print("* ");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void pattern7(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i+line==(n+1) || i==line) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void pattern8(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if((line==1) || line==n || i==1 || i==n || i==line || (i+line==n+1)) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void pattern9(int n) {
    int half = n%2==0 ? n/2 : (n/2)+1;
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i==1 || i==n || ((i==line || (i+line==n+1)) && line<=half)) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void pattern10(int n) {//pattern 1 other method
    int row = 1;
    int nStar=1;
    while(row<=n) {
      //work for each row
      for(int i=1;i<=nStar;i++) {
        System.out.print("* ");
      }

      //move to next line
      System.out.println();

      //work for next row
      row++;
      nStar++;
    }
  }

  //pattern1 not written earlier,forgot ,try to do
  public static void pattern11(int n) {//pattern 1 other method
    int row = 1;
    int nStar=n;
    while(row<=n) {
      //work for each row
      for(int i=1;i<=nStar;i++) {
        System.out.print("* ");
      }

      //move to next line
      System.out.println();

      //work for next row
      row++;
      nStar--;
    }
  }

  public static void pattern12(int n) {
    int row = 1;
    int nSpace = n-1;
    int nStar=1;
    while(row<=n) {
      //work for each row
      for(int i=1;i<=nSpace;i++) {
        System.out.print("  ");
      }
      for(int i=1;i<=nStar;i++) {
        System.out.print("* ");
      }

      //move to next line
      System.out.println();

      //work for next row
      row++;
      nStar++;
      nSpace--;
    }
  }

  public static void pattern13(int n) {
    int row = 1;
    int nSpace = (n*2)-2;
    int nStar=1;
    while(row<=n) {
      //work for each row
      int halfSpace = nSpace/2; //or choose directly n-1 as right space r not required
      for(int i=1;i<=halfSpace;i++) {
        System.out.print("  ");
      }
      for(int i=1;i<=nStar;i++) {
        System.out.print("* ");
      }
      // for(int i=halfSpace;i<=nSpace;i++) { //not matter as we will move to next line
      //   System.out.print("  ");
      // }
      //move to next line
      System.out.println();

      //work for next row
      row++;
      nStar+=2;
      nSpace-=2;
    }
  }

  public static void pattern14(int n) {
    int row =1;
    int nStar = (n*2)-1;
    int nSpace = 0;
    while(row<=n) {
      for(int space=1;space<=nSpace;space++) {
        System.out.print("  ");
      }
      for(int star = 1;star<=nStar;star++) {
        System.out.print("* ");
      }
      System.out.println();

      row++;
      nStar-=2;
      nSpace++;
    }
  }

  public static void pattern15(int n) {
    System.out.println(n/2);
    int row = 1;
    int nStar = 1;
    int nSpace = n/2;
    while(row<=n) {
      for(int space=1;space<=nSpace;space++) {
        System.out.print("  ");
      }
      for(int star = 1;star<=nStar;star++) {
        System.out.print("* ");
      }
      System.out.println();

      if(row<=n/2) {
        nSpace--;
        nStar+=2;
      } else {
        nSpace++;
        nStar-=2;
      }
      row++;
    }
  }

  public static void pattern16(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i==1 || i == n || ((i==line || i+line==n+1) && (line>n/2))) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  } 

  public static void pattern17(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i==1 || i == n || ((i==line || i+line==n+1) && (i<=(n/2)+1))) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }

  public static void pattern18(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i==1 || i == n || ((i==line || i+line==n+1) && (i>=(n/2)+1))) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }
  public static void pattern19(int n) {
    int nStar = n;
    int nSpace = 0;
    int row = 1;
    // System.out.println(n/2);
    while(row<=n) {
      for(int space = 1;space<=nSpace;space++) {
        System.out.print("  ");
      }
      for(int star=1;star<=nStar;star++) {
        System.out.print("* ");
      }
      System.out.println();
      // System.out.println(row);
      
      if(row<=n/2) {
        nStar-=2;
        nSpace++;
      } else {
        nStar+=2;
        nSpace--;
      }
      row++;
    }
  }
  public static void pattern20(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i==1 || i==n || line<=(n/2)+1 || line==i || line+i==(n+1)) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }

  public static void diamondChange(int n) {
    for(int line=1;line<=n;line++) {
      for(int i=1;i<=n;i++) {
        if(i==1 || i==n || line>=(n/2)+1 || line==i || line+i==(n+1)) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }

  public static void pattern22(int n) {
    int row = 1;
    int nStar = n;
    int nSpace = 0;
    while(row<=n) {

      for(int space=1;space<=nSpace;space++) {
        System.out.print("  ");
      }
      for(int star=1;star<=nStar;star++) {
        if(row>1 && row<=n/2) {
          if(star == 1 || star == nStar) {
            System.out.print("* ");
          }
        } else {
          System.out.print("* ");
        }
      }
      if(row<=n/2) {
        nStar-=2;
        nSpace++;
      } else {
        nStar+=2;
        nSpace--;
      }
      row++;
      System.out.println();
    }
  }
  // public static void pattern23(int n) {
  //   for(int row=1;row<=n;row++) {
  //     for(int i=1;i<=n;i++) {
  //       if(row==1 || row ==n || i==row || i+row==n+1 || (row>=n/2 && i>n/2)) {
  //         System.out.print("* ");
  //       } else {
  //         System.out.print("  ");
  //       }
  //     }
  //     System.out.println();
  //   }
  // }

  public static void printArrow1(int n) {
    int row = 1;
    int nStar = 1;
    int nSpace = n/2;
    while(row<=n) {
      for(int space=1;space<=nSpace && row!=(n/2+1);space++) {
        System.out.print("  ");
      }
      int nSt = row == (n/2+1) ? nStar : (nStar/2)+1;
      for(int star=1;star<=nSt;star++) {
       System.out.print("* ");
      }
      if(row<=n/2) {
        nStar+=2;
      } else {
        nStar-=2;
      }
      row++;
      System.out.println();
    }
  }

  public static void printArrow2(int n) {
    int row = 1;
    int nStar = 1;
    int nSpace = n/2;
    while(row<=n) {
      for(int space=1;space<=nSpace;space++) {
        if(row==(n/2)+1) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      for(int star=1;star<=nStar;star++) {
       System.out.print("* ");
      }
      if(row<=n/2) {
        nStar+=1;
      } else {
        nStar-=1;
      }
      row++;
      System.out.println();
    }

  }

  public static void hollowDiamond(int n) {
    int nStars = 1;
    int nSpace = n/2;
    int row =1;
    while(row<=n) {
      for(int space = 1;space<=nSpace;space++) {
        System.out.print("  ");
      }
      for(int star =1;star<=nStars;star++) {
       if(star ==1 || star == nStars) {
        System.out.print("* ");
       } else {
        System.out.print("  ");
       }
      }
      if(row<=n/2) {
        nStars+=2;
        nSpace--;
      } else {
        nStars-=2;
        nSpace++;
      }
      row++;
      System.out.println();
    }
  }

  //own method with n=7 mein n=5 diamond n=5 mein n=3 ka doamond
  public static void diamondFrame(int n) {
    int nStar = (n+1)/2;
    int nSpace = 1;
    for(int line=1;line<=n;line++) {
      int star =1;
      int space =1;
      for(int i=1;i<=n;i++) {
        if(line ==1 || line == n || i==1 || i==n) {
          System.out.print("* ");
        } else {
          if(star<=(nStar/2)) {
            System.out.print("* ");
            star++;
          } else if(space<=nSpace) {
            System.out.print("a ");
            space++;
          } else if(star<=(nStar)) {
            System.out.print("* ");
            star++;
          } 
        }
      }
      System.out.println();
        if(line>1 && line<=n/2) {
          nSpace+=2;
          nStar-=2;
        } else if(line>n/2) {
          nSpace-=2;
          nStar+=2;
        }
    }
  }

  //implement sir taught method
  public static void diamondFrame2(int n) {
    int nStar = 1;
    int nSpace = n/2;
    for(int line=1;line<=n;line++) {
      //will just print star instead of space in front and end of hollow diamond
      for(int space=1;space<=nSpace;space++) {
        System.out.print("* ");
      }
      for(int i=1;i<=nStar;i++) {
        if(i==1 || i==nStar){
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      for(int space=1;space<=nSpace;space++) {
        System.out.print("* ");
      }
      System.out.println();
        if(line<=n/2) {
          nSpace--;
          nStar+=2;
        } else {
          nSpace++;
          nStar-=2;
        }
    }
  }
}