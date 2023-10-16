import java.util.HashMap;
import java.util.HashSet;

public class Q1 {
   public static void main(String[] args) {
    // int arr[] = {1,22,2,9,8,6,7,5,10,11,14,12,15,13};
    // System.out.println(getLengthOfLargestSequence(arr));
    // int newArr[] = {2,2,1,1,5,3,2,4,4};
    // System.out.println(getLengthOfLargestSequenceDupAllowed(newArr));
    int finalArr[] = {1,10,9,2,3,8,7,4,6,15,14,11};
    System.out.println(maxLengthOFSequenceInArr(finalArr));
  }
    public static int getLengthOfLargestSequence(int arr[]) {
      int maxLength = 0;
      // find subset 
      for(int i=0;i<arr.length;i++) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int si = i;
        for(int j = i;j<arr.length;j++) {
          if(arr[j] > max) {
            max = arr[j];
          }
          if(arr[j]<min) {
            min = arr[j];
          }
          if(max-min == j-si) {
            if(max-min>maxLength+1) {
              maxLength = max-min+1;
            }
          }
        }
      }
      return maxLength;
    }
    public static int getLengthOfLargestSequenceDupAllowed(int arr[]) {
      int maxLength = 0;
      // find subset 
      for(int i=0;i<arr.length;i++) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int si = i;
        HashSet<Integer> hs = new HashSet<>();
        for(int j = i;j<arr.length;j++) {
          if(arr[j] > max) {
            max = arr[j];
          }
          if(arr[j]<min) {
            min = arr[j];
          }
          hs.add(arr[j]);
          if(hs.size()!=j-si+1) {
            break;//as if duplicate is there no need to check that start index subbarays
          }
          if((max-min == j-si)) {
            if(max-min>maxLength+1) {
              maxLength = max-min+1;
            }
          }
        }
      }
      return maxLength;
    }

    public static int maxLengthOFSequenceInArr(int arr[]) {
      HashMap<Integer,Boolean> hm = new HashMap<>();
      for(int val:arr) {
        hm.put(val,true);
      }
      for(int val:arr) {
        if(hm.containsKey(val-1)) {
          hm.put(val,false);
        }
      }
      int maxLength = 0;
      // System.out.println(hm.keySet());
      for(int key:hm.keySet()) {
        int length = 0;
        if(hm.get(key)) {
          int startingVar = key;
          // System.out.println(startingVar);
          while(hm.containsKey(startingVar)) {
            length++;
            startingVar+=1;
          }
          if(length>maxLength) {
            maxLength = length;
          }
        }
      }
      return maxLength;
    }
}
