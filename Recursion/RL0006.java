public class RL0006 {
  public static void main(String args[]) {
    // printPermutation("abc","");

    // printConfig_PlaceNIdenticalObjectsIntoKBoxes_Box_Decide(1,5,0,3,"");
    // int boxes = 3;
    // printConfig_PlaceNIdenticalObjectsIntoKBoxes_ObjectDecides(1,2,-1,new int[boxes]);



    // we start with obj1 and write1 here usually but as it is array so indexing is req so starting with 0
    // int objects[] = {1,2};
    // printConfig_PlaceNNonIdenticalObjectsIntoKBoxes_ObjectDecides(0,2,new int[3],objects);


    // taking 0 here for not taking case
    int objects[] = {1,2};
    int objectssedSoFar[] = new int[2];
    printConfig_PlaceNNonIdenticalObjectsIntoKBoxes_BoxDecides(0,2,new int[3],objects,objectssedSoFar,0,0);
  }  

  public static void printPermutation(String ques, String ans) {
    if(ques.length() == 0) {
      System.out.println(ans);
      return;
    }

    for(int i=0;i<ques.length();i++) {
      char ch = ques.charAt(i);
      String lp = ques.substring(0, i);
      String rp = ques.substring(i+1,ques.length());
      printPermutation(lp+rp,ans+ch+"");
    }
  }


  // identical object , box choses 

  public static void printConfig_PlaceNIdenticalObjectsIntoKBoxes_Box_Decide(int currbox,int totalBox , int ssf, int totalSelection , String ans) {

    if(currbox>totalBox) {
      if(ssf == totalSelection) {
        System.out.println(ans);
      }
      return;
    }

    // ya box object ko place krega ya to ni krega
    printConfig_PlaceNIdenticalObjectsIntoKBoxes_Box_Decide(currbox+1, totalBox, ssf+1, totalSelection, ans+'i');
    printConfig_PlaceNIdenticalObjectsIntoKBoxes_Box_Decide(currbox+1, totalBox, ssf, totalSelection, ans+'_'); 
  }

  // identical objects , object choses 

  public static void printConfig_PlaceNIdenticalObjectsIntoKBoxes_ObjectDecides(int currObj, int totalObj , int lastBoxUsed, int boxes[]) {

    if(currObj > totalObj) {
      for(int val:boxes) {
        if(val == 1) {
          System.out.print("i");
        } else {
           System.out.print("_");
        }
      }
      System.out.println();
      return;
    }

    for(int boxIdx=lastBoxUsed+1;boxIdx<boxes.length;boxIdx++) {
      boxes[boxIdx] = 1;
      printConfig_PlaceNIdenticalObjectsIntoKBoxes_ObjectDecides(currObj+1,totalObj,boxIdx,boxes);
      boxes[boxIdx] = 0;
    }
  }



   // non identical objects , object choses 

  public static void printConfig_PlaceNNonIdenticalObjectsIntoKBoxes_ObjectDecides(int currObj, int totalObj , int boxes[], int objects[]) {
    if(currObj == totalObj) {
      for(int val:boxes) {
        if(val!=0) {
        System.out.print(val);
      } else {
        System.out.print("_");
      }
    }
    System.out.println();
    return;
  }
   
    for(int i=0;i<boxes.length;i++) {
      if(boxes[i]==0) {
        boxes[i] = objects[currObj];
        printConfig_PlaceNNonIdenticalObjectsIntoKBoxes_ObjectDecides(currObj+1,totalObj,boxes,objects);
        boxes[i] = 0;
      }
    }
  }



   // non identical objects , Box choses 

  public static void printConfig_PlaceNNonIdenticalObjectsIntoKBoxes_BoxDecides(int currObj, int totalObj , int boxes[], int objects[],int objectsUsedSF[],int currbox, int objUsed) {

    if(currbox == boxes.length) {
      if(objUsed == objects.length) {
        // System.out.println(objUsed + " " + objects.length);
        for(int val:boxes) {
          if(val == 0) {
            System.out.print("_");
          } else {
            System.out.print(val);
          }
        }
        System.out.println();
      }
      return;
    }

    for(int i=0;i<objects.length;i++) {
      if(objectsUsedSF[i] == 0) {
        objectsUsedSF[i] = objects[i];
        boxes[currbox] = objects[i];
        printConfig_PlaceNNonIdenticalObjectsIntoKBoxes_BoxDecides(currObj+1,totalObj,boxes,objects,objectsUsedSF,currbox+1,objUsed+1);
        boxes[currbox] = 0;
        objectsUsedSF[i] = 0;
      }
    }
    printConfig_PlaceNNonIdenticalObjectsIntoKBoxes_BoxDecides(currObj,totalObj,boxes,objects,objectsUsedSF,currbox+1,objUsed);

  }
  

}



