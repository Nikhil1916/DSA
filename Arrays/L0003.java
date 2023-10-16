import java.util.Scanner;
public class L0003 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0;i<n;i++) {
      arr[i] = sc.nextInt();
    }
    findSubarray(n,arr);
    // int x = sc.nextInt();
    // findFirstLastInd(arr,x);
  }
  public static void findSubarray(int n,int arr[]) {
   for(int si=0;si<n;si++) {
    for(int ei=si;ei<n;ei++) {
      for(int i=si;i<=ei;i++) {
        System.out.print(arr[i]+" ");
      }
      System.out.println();
    }
   }   
  }
  public static void findFirstLastInd(int v[],int x) {

    int si = 0;
    int ei = v.length-1;
    int firstInd = -1;
    while(si<=ei) {
        int mid = (si+ei)/2;
        int midEl = v[mid];
        if(midEl == x) {
          firstInd = mid;
          ei = mid-1;
        } else if(x>midEl) {
            si = mid+1;
        } else ei = mid-1;
        
    }
    si = 0;
    ei = v.length-1;
    int lastInd = -1;
    while(si<=ei) {
        int mid = (si+ei)/2;
        int midEl = v[mid];
        if(midEl == x) {
          lastInd = mid;
          si = mid+1;
        } else if(x>midEl) {
            si = mid+1;
        } else ei = mid-1;
        
    }
    // int arr[] = {firstInd,lastInd};
    // return arr;
    System.out.println(firstInd+" "+lastInd);
  }
}
