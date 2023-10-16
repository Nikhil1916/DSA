
public class L0003 {
  public static void main(String args[]) {
    int arr[] = {14,11,14,23,14,5,14};
    // displayArr(arr,0);
    // displayArrRev(arr,0);
    // System.out.println(findFirstOccurance(arr,0,14));
    // System.out.println(findLastOccurance(arr,0,24));
      // int k = 24;
      // int ans[] = findAllOcc(arr,0,0,k);
      // for(int i=0;i<ans.length;i++) {
      //    System.out.print(ans[i]+" ");;
      // }
      // System.out.print(ans.length);
      // System.out.println(arrayMin(arr, 0));
      int new_arr[] = {90,1,3,25,60,100,30,70,8,9};
      // int copy_arr[] = {20,20};
      int ans[] = findFirstSecondMax(new_arr, 0);
      for(int num : ans) 
      System.out.println(num);
  }

  public static void displayArr(int arr[],int idx) {
    if(idx == arr.length) {
      return;
    }
    System.out.println(arr[idx]);
    displayArr(arr, idx+1);
  }

  public static void displayArrRev(int arr[],int idx) {
    if(idx == arr.length) {
      return;
    }
    displayArrRev(arr, idx+1);
    System.out.println(arr[idx]);
  }

  public static int findFirstOccurance(int arr[],int idx,int k){
    if(arr.length == idx) {
      return -1;
    }
    if(arr[idx] == k) {
      return idx;
    }
    return findFirstOccurance(arr, idx+1, k);
  }

  public static int findLastOccurance(int arr[],int idx,int k){
    if(arr.length == idx) {
      return -1;
    }
    int rRes  = findLastOccurance(arr, idx+1, k);
    if(rRes == -1 && arr[idx] == k) {
      return idx;
    }
    return rRes;
  }

  public static int[] findAllOcc(int arr[],int count,int idx,int k) {
    if(idx == arr.length) {
      return new int[count];
    }
    if(arr[idx] == k) {
      int ans[] =  findAllOcc(arr, count+1, idx+1, k);
      ans[count] = idx; 
      return ans;
    } else {
      int ans[] =  findAllOcc(arr, count, idx+1, k);
      return ans;
    }
  }

  public static int sumOfArr(int arr[],int idx) {
    if(idx == arr.length) {
      return 0;
    }
    int rRes = sumOfArr(arr, idx+1);
    return rRes + arr[idx];
  }

  public static int arrayMax(int arr[],int idx) {
    if(idx == arr.length) {
      return Integer.MIN_VALUE;
    }
    int rRes = arrayMax(arr, idx+1);
    if(rRes < arr[idx]) {
      return arr[idx];
    }
    return rRes;
  }
  
  public static int arrayMin(int arr[],int idx) {
    if(idx == arr.length) {
      return Integer.MAX_VALUE;
    }
    int rRes = arrayMin(arr, idx+1);
    if(rRes > arr[idx]) {
      return arr[idx];
    }
    return rRes;
  }

  public static int[] findFirstSecondMax(int arr[],int idx) {
    if(arr.length == idx) {
      return new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE};
    }

    int rRes[] = findFirstSecondMax(arr, idx+1);
    if(rRes[0] < arr[idx]) {
      rRes[1] = rRes[0];
      rRes[0] = arr[idx];
    } else if(rRes[1] < arr[idx] && rRes[0] > arr[idx]) {
      rRes[1] = arr[idx];
    }
    return rRes;
  } 
  
}
