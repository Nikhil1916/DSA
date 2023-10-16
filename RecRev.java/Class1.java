import java.util.ArrayList;

public class Class1 {

  public static void main(String args[]) {
    // String sub = "abc";
    // ArrayList<String> arr = getSub(sub,0);
    // System.out.println(arr);

    // int stairs = 3;
    // System.out.println(getWays(stairs));
    // printCombination(1,"",4,3,1);
    printCombination2(4,new int[4], 1 , 3, -1);
    // int objects[] = {1,2};
    // printPermutation(0,2,new int[3],objects);
  }

  public static ArrayList<String> getSub(String s,int i) {

    ArrayList<String> ans = new ArrayList<>();
    if(i == s.length()) {
      ans.add("");
      return ans;
    }
    
    ArrayList<String> recAns = getSub(s,i+1);
    for(String st:recAns) {
      ans.add(s.charAt(i)+st);
    }
    for(String st:recAns) {
      ans.add(st);
    }
    return ans;
  }
  

  public static int getWays(int n) {
    if(n == 0) {
      return 1;
    }

    if(n < 0) {
      return 0;
    }
    int ans = 0;
    for(int i=1;i<=3;i++) {
      ans+=getWays(n-i);
    }
    return ans;
  }


// box choses
public static void printCombination(int boxNo, String ans , int totalBox, int totalObj,int currObj) {

if(boxNo > totalBox) {
  if(currObj == totalObj) {
    System.out.println(ans);
  }
  return;
}

printCombination(boxNo+1,ans+"i",totalBox,totalObj,currObj+1);
printCombination(boxNo+1,ans+"_",totalBox,totalObj,currObj);
}

// object chooses
public static void printCombination2(int totalBox, int boxes[],int currObj , int totalObj , int lastPlacedIdx) {

  if(currObj == totalObj) {
    for(int val:boxes) {
      if(val == 1) {
        System.out.print("i");
      } else {
        System.out.print("_");
      }
    }
    System.out.println();
  }

  for(int i=lastPlacedIdx+1;i<totalBox;i++) {
    boxes[i] = 1;
    printCombination2(totalBox, boxes,currObj+1, totalObj, i);
    boxes[i] = 0;
  }
}


// object chooses
public static void printPermutation(int currObj, int totalObj, int boxes[], int objects[]) {

  if(currObj == objects.length) {
    for(int val:boxes) {
      System.out.print(val == 0 ? "_" : val);
    }
    System.out.println();
    return;
  }

  for(int i=0;i<boxes.length;i++) {
    if(boxes[i] == 0) {
      boxes[i] = objects[currObj];
      printPermutation(currObj+1, totalObj, boxes, objects);
      boxes[i] = 0;
    } 
  }

}
}