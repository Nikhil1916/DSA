
public class Rotatearray {
  public static void main(String args[]) {
    int arr[] = {11,5,4,3,2,1};
    int k=-4;
    rotate(arr, k);
    display(arr);
  }
  public static void rotate(int arr[],int k) {
    int n = arr.length;
    k=k%n;
    if(k<0) {
      k = n + k;
    }

    reverse(arr, n-k, n-1);
    reverse(arr, 0, n-k-1);
    reverse(arr, 0, n-1);
  }
  public static void reverse(int arr[],int li,int ri) {
    while(li<ri) {
      int temp = arr[li];
      arr[li] = arr[ri];
      arr[ri] = temp;
      li++;
      ri--;
    }
  }

  public static void display(int arr[]) {
    for(int i=0;i<arr.length;i++) {
      System.out.print(arr[i]+" ");
    }
  }
}
