import java.util.ArrayList;
import java.util.Stack;

public class constructTree {
  private static class Node{
    int data;
  
    Node left,right;
  
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
  }
  
  private static class PairInputHelper{
    Node node;
    int state;
  
    PairInputHelper(Node node){
        this.node = node;
        this.state = 0;
    }
  }
public static void main(String[] args) {
  Integer input[] = {10,20,40,null,null,50,90,null,null,null,30,60,70,null,null,80,null,null,null};
  Node root = constructBT(input);
  // display(root);
  System.out.println(findSum(root));
  System.out.println(findSize(root));
  System.out.println(findHeight(root));
  System.out.println(findMax(root));
  System.out.println(find(root,60));
  System.out.println(find(root,160));
  System.out.println(nodeToRootPath(root,60));
  System.out.println(nodeToRootPath(root,160));
  printkLevelDown(root, 3);
  
  
}
static Node constructBT(Integer inp[]){
  Stack<PairInputHelper> st = new Stack<>();
  Node root = new Node(inp[0]);
  st.add(new PairInputHelper(root));
  int i = 1;
  while(st.isEmpty() == false) {
    PairInputHelper topPair = st.peek();
    if(topPair.state == 0 || topPair.state == 1) {
      if(inp[i] == null) {
        topPair.state++;
      } else {
        Node n = new Node(inp[i]);
        if(topPair.state ==0) {
          topPair.node.left = n; 
        } else {
          topPair.node.right = n;
        }
        topPair.state++;
        st.add(new PairInputHelper(n));
      }
      i++;
    } else {
      st.pop();
    }
  }
  return root;
}
  static void display(Node node){
    if(node == null) {
      return;
    }
    System.out.print(node.left == null ? "." : node.left.data);
    System.out.print(" "+node.data+" ");
    System.out.println(node.right == null ? "." : node.right.data);
    display(node.left);
    display(node.right);
  }

  static int findSum(Node root) {
    if(root == null) return 0;
    int sum = 0;
    sum+=findSum(root.left);
    sum+=findSum(root.right);
    return sum + root.data;
  }

  static int findSize(Node node){
    int size = 0;
    if(node == null) {
      return size;
    }
    size+=findSize(node.left);
    size+=findSize(node.right);
    return size + 1;
  }

  static int findHeight(Node node){
    if(node == null) {
      return -1;
    }
    int lh = findHeight(node.left);
    int rh = findHeight(node.right);
    return Math.max(lh, rh)+1;
  }

  static int findMax(Node node){
    if(node == null) {
      return Integer.MIN_VALUE;
    }      
    int lMax = findMax(node.left);
    int rMax = findMax(node.right);
    return Math.max(Math.max(lMax, rMax),node.data);
  }

  static boolean find(Node node, int val) {
    if(node == null) return false;
    if(node.data == val) {
      return true;
    }
    Boolean lc = find(node.left,val);
    if(lc) return true;
    Boolean rc = find(node.right,val);
    return rc;
  }

  static ArrayList<Integer> nodeToRootPath(Node node, int val) {
    ArrayList<Integer> base = new ArrayList<>();
    if(node == null) return base;
    if(node.data == val) {
      base.add(node.data);
      return base;
    }

    ArrayList<Integer> lc = nodeToRootPath(node.left, val);
    if(lc.size() > 0) {
      lc.add(node.data);
      return lc;
    }

    
    ArrayList<Integer> rc = nodeToRootPath(node.right, val);
    if(rc.size() > 0) {
      rc.add(node.data);
      return rc;
    }

    return new ArrayList<>();
  }


  static void printkLevelDown(Node node,int level){
        if(level == 0) {
          System.out.println(node.data);
        }
        if(node.left!=null) {
          printkLevelDown(node.left, level-1);
        }
        if(node.right!=null) {
          printkLevelDown(node.right, level-1);
        }
  }
}
