
// package generictree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

class LOWrapper {
    Node node;
    int level;
    LOWrapper(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Node {
    private int val;
    private ArrayList<Node> children;

    Node() {
        this.val = 0;
        this.children = new ArrayList<>();
    }

    Node(int val) {
        this();
        this.val = val;
    }

    void addChildren(Node node) {
        this.children.add(node);
    }

    int getVal() {
        return this.val;
    }

    ArrayList<Node> getChildren() {
        return this.children;
    }
}

public class GenericTree {

    static class MultiSolverPair{
        int sum,size,max,min;

        MultiSolverPair(){
            sum = 0;
            size = 0;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }

        MultiSolverPair(int sum,int size,int max,int min){
            this.sum = sum;
            this.size = size;
            this.max = max;
            this.min = min;
        }
        public String toString() {
            return sum+" "+size+" "+min+" "+max;
        }
    }

    static class MultisolverCielAndFloorPair {
        int ciel = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;

        MultisolverCielAndFloorPair(int ciel, int floor) {
            this.ciel = ciel;
            this.floor = floor;
        }

        public String toString() {
            return ciel+" "+floor ;
        }
    }

    static Node construct(Integer inSeq[]) {
        // logic here
        Stack<Node> st = new Stack<>();
        // int idx = 0;
        Node root = new Node(inSeq[0]);
        st.push(root);
        for (int i = 1; i < inSeq.length; i++) {
            if (inSeq[i] == null) {
                st.pop();
            } else {
                Node n = new Node(inSeq[i]);
                Node parent = st.peek();
                parent.addChildren(n);
                st.push(n);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // Integer inSeq[] = { 10, 20, 40, 50, 60, null, 70, null, null, null, null, 30, 80, null, 90, null, 100, null,
        //         null, null
        // };
        Integer inSeq[] = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = construct(inSeq);
        // display(root);
        // System.out.println(sumOFGT(root));

        // System.out.println(findInGT(root, 170));

        // postOrder(root);
        // printEdgeView(root);.
        // System.out.println(maxOfGt(root));
        //  System.out.println(minOfGt(root));
        // minOfGt()
        // levelOrderTraversal(root);
        // levelOrderTraversalLevelWise(root);
        // levelOrderTraversalLevelWiseUsing2Queues(root);
        // levelOrderTraversalLevelWiseUsingQueueSize(root);
        // linearizeTree(root);
        // removeLeaf(root);
        // display(root);
        // System.out.println(nodeToRootPath(root,100));

        // System.out.println(lowestCommonAncestor(root,110,120));
        // System.out.println(lowestCommonAncestor(root,70,120));
        // System.out.println(lowestCommonAncestor(root,80,120));

        // System.out.println(findDistanceBWNodes(root,70,120));


        // ciel = Integer.MAX_VALUE; // as it is static keyword so we should intitalize it everrytime before making class instance
        // floor = Integer.MIN_VALUE;
        // findCielAndFloor(root, 75);
        // System.out.println(ciel+" "+floor); 

        
        // ciel = Integer.MAX_VALUE; // as it is static keyword so we should intitalize it everrytime before making class instance
        // floor = Integer.MIN_VALUE;
        // findCielAndFloor(root, 80);
        // System.out.println(ciel+" "+floor); 

        // System.out.println(findMaxMinSumSize(root));
        // System.out.println(multisolverCielAndFloor(root,75));

        System.out.println(findKthLargest(root, 5));

        Integer inSeq2[] = {10,20,40,null,50,60,70,null,80,100,110,null,null,null,90,null,null,null,null,30,120,190,200,210,220,230,240,250,null,null,null,null,null,null,null,null,270,130,260,140,150,160,170,180,null,null,null,null,null,null,null,null,null,null};
        Node root2 = construct(inSeq2);
        System.out.println(diameterOfTree(root2));
        // System.out.println(diameterOfTreeOptimized(root2));
    }

    static void display(Node root) {
        System.out.print(root.getVal() + " --> ");
        ArrayList<Node> children = root.getChildren();
        if (children.size() == 0) {
            System.out.println(".");
        } else {
            for (Node node : children) {
                System.out.print(node.getVal() + " ");
            }
            System.out.println();
            for (Node node : children) {
                display(node);
            }
        }
    }

    static int sumOFGT(Node node) {
        int sum = 0;
        for(Node child:node.getChildren()) {
            sum+=sumOFGT(child);
        }
        return sum + node.getVal();
    }

    static Boolean findInGT(Node node, int findV) {
        if(node.getVal() == findV) {
            return true;//a
        }
        for(Node child:node.getChildren()) {
            Boolean isNodeThere = findInGT(child,findV); //b
            if(isNodeThere) return true;//c
        }
        return false;//d
    }

    static void preOrder(Node node) {
        System.out.println(node.getVal());
        for(Node child:node.getChildren()) {
            preOrder(child);
        }
    }

      static void postOrder(Node node) {
          for(Node child:node.getChildren()) {
              postOrder(child);
            }
            System.out.println(node.getVal());
    }

    static void printEdgeView(Node node){
        for(Node child : node.getChildren()){
            System.out.println(node.getVal()+"->"+ child.getVal());
            printEdgeView(child);
            System.out.println(child.getVal()+"->"+ node.getVal());
        }
    }

    static void viewHelper(Node node){
        System.out.println("PreNode"+node.getVal());

        for(Node child : node.getChildren()){

            System.out.println("PreEdge ["+node.getVal()+"->"+child.getVal()+"]");

            viewHelper(child);

            System.out.println("PostEdge ["+node.getVal()+"->"+child.getVal()+"]");

        }

        System.out.println("PostNode"+node.getVal());
    }

    static int maxOfGt(Node node) {
        int MAX_INTEGER = Integer.MIN_VALUE;
        for(Node child:node.getChildren()) {
            int res = maxOfGt(child);//a
            if(res > MAX_INTEGER) {
                MAX_INTEGER = res;//b
            }
        }
        return Math.max(MAX_INTEGER, node.getVal());//c
    }

      static int minOfGt(Node node) {
        int MIN_INTEGER = Integer.MAX_VALUE;
        for(Node child:node.getChildren()) {
            int res = minOfGt(child);
            if(res < MIN_INTEGER) {
                MIN_INTEGER = res;
            }
        }
        return Math.min(MIN_INTEGER, node.getVal());
    }

    // static void levelOrderTraversal(Node node) {
    //     Queue<Node> que = new ArrayDeque<>();
    //     que.add(node);
    //     while(que.size() > 0) {
    //         Node top = que.remove();
    //         System.out.println(top.getVal());
    //         for(Node child:top.getChildren()) {
    //             que.add(child);
    //         }
    //     }
    // }

    // using delimeter 
     static void levelOrderTraversalLevelWise(Node node) {
        Queue<Node> que = new ArrayDeque<>();
        que.add(node);
        Node specialNode = new Node(Integer.MAX_VALUE);//cannot add null directly due to null error exception
        que.add(specialNode);
        while(que.size() > 0) {
            Node top = que.remove();
            if(top == specialNode) {
                System.out.println();
                if(que.size()==0) {
                    break;
                } else {
                    que.add(specialNode);
                    continue;
                }
            }
            System.out.print(top.getVal()+" ");
            for(Node child:top.getChildren()) {
                que.add(child);
            }
        }
    }

    static void levelOrderTraversalLevelWiseUsing2Queues(Node node) {
        Queue<Node> currentLevQ = new ArrayDeque<>();
        Queue<Node> nextLevelQ = new ArrayDeque<>();
        currentLevQ.add(node);
        while(currentLevQ.size() > 0) {
            Node top = currentLevQ.remove();
            System.out.print(top.getVal()+" ");
            for(Node child:top.getChildren()) {
                nextLevelQ.add(child);
            }

            if(currentLevQ.size() == 0) {
                System.out.println();
                currentLevQ = nextLevelQ;
                nextLevelQ = new ArrayDeque<>();
            }
        }
    }

     static void levelOrderTraversalLevelWiseUsingQueueSize(Node node) {
        Queue<Node> que = new ArrayDeque<>();
        que.add(node);
        while(que.size() > 0) {
            int k = que.size();
            while(k-- > 0) {
            Node top = que.remove();
            System.out.print(top.getVal()+" ");
            for(Node child:top.getChildren()) {
                que.add(child);
            }
            }
            System.out.println();
        }
    }

    static void levelOrderTraversalLevelWiseUsingLOW_WrapperApproach(Node node) {
        Queue<LOWrapper> que = new ArrayDeque<>();
        LOWrapper wrappedNode = new LOWrapper(node, 1);
        int currentL = 1;
        que.add(wrappedNode);
        while(que.size() > 0) {
            LOWrapper top = que.remove();
            if(top.level!=currentL) {
                currentL++;
                System.out.println();
            }
            System.out.print(top.node.getVal()+" ");
            for(Node child:top.node.getChildren()) {
                que.add(new LOWrapper(child, currentL+1));
            }
        }
    }


    // 8/9/23


    static void linearizeTree(Node node) {
        for(Node child:node.getChildren()) {
            linearizeTree(child);
        }
        while(node.getChildren().size() > 1) {
            Node lastNode = node.getChildren().get(node.getChildren().size()-1);
            Node secondLastTail = getTail(node.getChildren().get(node.getChildren().size()-2));

            // unlink last node
            node.getChildren().remove(node.getChildren().size()-1);

            secondLastTail.addChildren(lastNode);
        }
    }

    // 1st way to get tail via recursion 
    // static Node getTail(Node node) {
    //     if(node.getChildren().size() == 0) {
    //         return node;
    //     } 
    //     return getTail(node.getChildren().get(0));
    // }

    // 2nd way to find tail via iteration
     static Node getTail(Node node) {
        while(node.getChildren().size()>0) {
            node = node.getChildren().get(0);
        }
        return node;
     }


    static void removeLeaf(Node node) {

        for(int i=node.getChildren().size()-1;i>=0;i--) { //.a
            Node child = node.getChildren().get(i);
            if(child.getChildren().size()==0) {//b
                node.getChildren().remove(i);
            }
        }

        for(Node child:node.getChildren()) {//c
            removeLeaf(child);
        }
    }


    // 9/9/23
    
    static ArrayList<Integer> nodeToRootPath(Node node, int val) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node.getVal() == val) {
            ans.add(node.getVal());
            return ans;
        }
        for(Node child:node.getChildren()) {
            ArrayList<Integer> recans = nodeToRootPath(child, val);
            if(recans.size() > 0) {
                recans.add(node.getVal());
                return recans;
            }
        }
        return ans;
    }

    static int lowestCommonAncestor(Node root, int v1, int v2) {
        int LCA = -1;
        ArrayList<Integer> path1 = nodeToRootPath(root, v1);
        ArrayList<Integer> path2 = nodeToRootPath(root, v2);
        // System.out.println(path1 + " " + path2);
        if(path1.size() > 0 && path2.size() > 0) {
            int i = path1.size()-1;
            int j = path2.size()-1;
            while(i>=0 && j>=0 && path1.get(i) == path2.get(j)) {
                i--;
                j--;
            }
            LCA = path1.get(i+1);
        }
        return LCA;
    }

    static int findDistanceBWNodes(Node root, int v1,int v2) {
        int distance = -1;
        ArrayList<Integer> path1 = nodeToRootPath(root, v1);
        ArrayList<Integer> path2 = nodeToRootPath(root, v2);
        if(path1.size() > 0 && path2.size() > 0) {
            int i = path1.size()-1;
            int j = path2.size()-1;
            while(i>=0 && j>=0 && path1.get(i) == path2.get(j)) {
                i--;
                j--;
            }
            distance = i+j+2;
        }
        return distance;
    }


    // 10/9/23
    static int ciel;
    static int floor;
    static void findCielAndFloor(Node node, int val) {
        if(node.getVal() > val) {
            ciel = Math.min(node.getVal(), ciel);
        } else if(node.getVal() < val) {
            floor = Math.max(node.getVal(), floor);
        } else {
            ciel = floor = val;
        }

        for(Node child:node.getChildren()) {
            findCielAndFloor(child, val);
        }
    }

    static MultiSolverPair findMaxMinSumSize(Node node){
        int sum = node.getVal();
        int size = 1;
        int min = node.getVal();
        int max = node.getVal();

        for(Node child:node.getChildren()) {
            MultiSolverPair recans = findMaxMinSumSize(child);
            sum+=recans.sum;
            size+=recans.size;
            max = Math.max(recans.max, max);
            min = Math.min(recans.min,min);
        }

        return new MultiSolverPair(sum, size, max, min);    
    }

    static MultisolverCielAndFloorPair multisolverCielAndFloor(Node node, int target) {
        int ciel = node.getVal() >= target ? node.getVal() : Integer.MAX_VALUE;
        int floor = node.getVal() <= target ? node.getVal() : Integer.MIN_VALUE;
        for(Node child:node.getChildren()) {
            MultisolverCielAndFloorPair recans = multisolverCielAndFloor(child, target);
            ciel = Math.min(recans.ciel, ciel);
            floor = Math.max(recans.floor, floor);
        }
        return new MultisolverCielAndFloorPair(ciel, floor);
    }


    static int findKthLargest(Node root, int k) {
        int kthLargest = Integer.MAX_VALUE;
        while(k-->0) {
          MultisolverCielAndFloorPair kthLargestPair = multisolverCielAndFloorFOrKthLargest(root, kthLargest);
          kthLargest = kthLargestPair.floor;
        //   System.out.println(kthLargest+ "kth la");
        }
        return kthLargest;
    }

    static MultisolverCielAndFloorPair multisolverCielAndFloorFOrKthLargest(Node node, int target) {
        int ciel = node.getVal() > target ? node.getVal() : Integer.MAX_VALUE;
        int floor = node.getVal() < target ? node.getVal() : Integer.MIN_VALUE;
        for(Node child:node.getChildren()) {
            MultisolverCielAndFloorPair recans = multisolverCielAndFloorFOrKthLargest(child, target);
            ciel = Math.min(recans.ciel, ciel);
            floor = Math.max(recans.floor, floor);
        }
        return new MultisolverCielAndFloorPair(ciel, floor);
    }


    // 16/9/23

    static int heightOfTree(Node node){
        int ht = -1;
        for(Node child : node.getChildren()){
            int cht = heightOfTree(child);
            ht = Math.max(ht,cht);
        }
        return ht + 1;
    }

    // diamter of tree
    static int diaOfTreeFinalAns;

    // normal diameter of tree
    static void diameterOfNode(Node root){
        // logic
        int maxH = -1;
        int secondMaxH = -1;
        for(Node child:root.getChildren()) {
            int height = heightOfTree(child);
            if(height > maxH) {
                secondMaxH = maxH;
                maxH = height;
            } else if(height > secondMaxH) {
                secondMaxH = height;
            }
        }
        diaOfTreeFinalAns = Math.max(maxH + secondMaxH + 2, diaOfTreeFinalAns);
    }
    
    static void diameterOfTreeHelper(Node node) {
        for(Node child:node.getChildren()) {
            diameterOfTreeHelper(child);
        }
        diameterOfNode(node);
    }
    
    static int diameterOfTree(Node root){
        diaOfTreeFinalAns = -1;
        diameterOfTreeHelper(root);
        return diaOfTreeFinalAns;
    }


    // optimized diameter of tree
    static int diameterOfTreeOptimized(Node root){
        diaOfTreeFinalAns = -1;
        diameterOfTreeHelperOptimized(root);
        return diaOfTreeFinalAns;
    }

    static int diameterOfTreeHelperOptimized(Node node) {
        int lh = -1;
        int rh = -1;
        for(Node child:node.getChildren()) {
            int cht = diameterOfTreeHelperOptimized(child);
            if(cht>lh) {
                rh = lh;
                lh = cht;
            } else if(cht>rh) {
                rh = cht;
            }
        }

        int don = lh + rh + 2;//diameter of node
        if(don > diaOfTreeFinalAns ) {
            diaOfTreeFinalAns = don;
        }

        return lh+1;//lh is max height only +1 as this node also added
    }


}
