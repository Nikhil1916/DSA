public class Practice { 
  public static void main(String args[]) {
    int arr[] = {1,2,4,4,5,4,7};
    // displayArrRev(arr,0);
    // System.out.println(findLast(arr,0,7));
    for(int num:findAllOcc(arr,0,41,0)) {
      System.out.print(num+" ");
    }
  }

  public static void printArray(int arr[],int n) {
    if(arr.length == n) {
      return;
    }
    System.out.println(arr[n]);
    printArray(arr, n+1);
  }

  public static void displayArrRev(int arr[],int n) {
    if(n == arr.length) {
      return;
    }
    displayArrRev(arr,n+1);
    System.out.println(arr[n]);
  }

  public static int findFirst(int arr[],int idx,int k) {
    if(arr.length == idx) {
      return -1;
    }
    if(arr[idx] == k) {
      return idx;
    }
    return findFirst(arr, idx+1, k);
  }

  public static int findLast(int arr[],int idx,int k) {
    if(arr.length == idx) {
      return -1;
    }

    int rRes = findLast(arr, idx+1, k);
    if(rRes == -1 && arr[idx] == k) {
      return idx;
    }
    return rRes;
  }

  public static int[] findAllOcc(int arr[],int idx,int k,int freq) {
    if(arr.length == idx) {
      int res[] = new int[freq];
      return res;
    }
    if(arr[idx] == k) {
      int rRes[] = findAllOcc(arr, idx+1, k, freq+1);
      rRes[freq] = idx;
      return rRes; 
    } else {
      int rRes[] = findAllOcc(arr, idx+1, k, freq);
      return rRes;
    }
  }

}
