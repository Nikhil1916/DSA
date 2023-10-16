import java.util.ArrayList;
import java.util.Stack;

class Node {
  private int data;
  private ArrayList<Node> children;
  Node(int val) {
    this.data = val;
    this.children = new ArrayList<>();
  }

  int getVal() {
    return this.data;
  }

  ArrayList<Node> getChildren() {
    return this.children;
  } 

  void addChildren(Node child) {
    this.children.add(child);
  }

}


class constructTree {
  
  static Node construct(Integer inseq[]) {
    Stack<Node> st = new Stack<>();
    Node root = new Node(inseq[0]);
    st.push(root);
    int i = 1;
    while(st.size() > 0) {
      Node top = st.peek();
      if(inseq[i]!=null) {
        Node n = new Node(inseq[i]);
        top.addChildren(n);
        st.add(n);
      } else {
        st.pop();
      }
      i++;
    }
    return root;
  }

  public static void main(String args[]) {
    Integer inSeq[] = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
    Node root = construct(inSeq);
    display(root);
  }

  static void display(Node root) {
    System.out.print(root.getVal()+" -> ");
    for(Node child:root.getChildren()) {
      System.out.print(child.getVal()+" , ");
    }
    System.out.println();
    for(Node child:root.getChildren()) {
      display(child);
    }
    
  }

  int sumOFGt(Node node) {
    int sum = 0;
    for(Node child: node.getChildren()) {
      sum+=sumOFGt(child);
    }
    return sum;
  }


}