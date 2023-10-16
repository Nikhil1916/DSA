
public class CloneLL{

    public static class SimpleNode{
        int data;
        SimpleNode next;
    }

    public static class LinkedList{
        SimpleNode head;

        public void addLast(int val){
            SimpleNode node = new SimpleNode();
            node.data = val;

            if(head == null){
                head = node;
            }else{
                SimpleNode ptr = head;
                while(ptr.next != null){
                    ptr = ptr.next;
                }
                ptr.next = node;
            }
        }
    }
    public static void displayLinkedList(SimpleNode head){
        while(head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(".");
    }

    public static SimpleNode cloneSimpleLL(SimpleNode head){
        // logic
        SimpleNode cloneList = new SimpleNode();
        SimpleNode dummyPtr = cloneList;
        SimpleNode ptr = head;
        while(ptr!=null) {
          SimpleNode newNode = new SimpleNode();
          newNode.data = ptr.data;
          dummyPtr.next = newNode;
          dummyPtr = dummyPtr.next;
          ptr = ptr.next;
        }
        return cloneList.next;
        }

    public static void main(String args[]){
        LinkedList org = new LinkedList();

        org.addLast(10);
        org.addLast(20);
        org.addLast(30);
        org.addLast(40);
        org.addLast(50);
        org.addLast(60);
        org.addLast(70);
        displayLinkedList(org.head);

        SimpleNode clonedHead = cloneSimpleLL(org.head);

        displayLinkedList(clonedHead);
    }
}