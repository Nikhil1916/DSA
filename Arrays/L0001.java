public class L0001 {
  public static void main(String args[]) {
    // int n = 5;
    // int arr[]=new int[n];
    // System.out.println(arr);
    // System.out.println(arr.length);
    // for(int i=0;i<arr.length;i++) {
    //   System.out.println(i+" -> "+arr[i]);
    // }
    // System.out.println();
    // arr[0]=1;
    // arr[1]=2;
    // for(int i=0;i<arr.length;i++) {
    //   System.out.println(i+" -> "+arr[i]);
    // }
    int arr[] = {12,35,1,10,74,1};
    printLargest(arr);
  }
  public static void printLargest(int arr[]) {
    int max = Integer.MIN_VALUE;
    for(int val:arr) {
      if(val>max) {
        max = val;
      }
    }
    System.out.println(max);
  }  
}
