
public class L0001 {
  public static class Node {
    int data;
    Node next;
  }  
  public static class LinkedList {
    Node head,tail;
    int size;

    public void addFirst(int val){
      Node node = new Node();
      node.data = val;

      if(size == 0){
          head = tail = node;
      }else {
          node.next = head;
          head = node;
      }
      size++;
  }

  public void addLast(int val) {
    Node node = new Node();
    node.data = val;
    if(size == 0) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public void display() {
    Node ptr = head;
    while(ptr!=null) {
      System.out.print(ptr.data+" -> ");
      ptr = ptr.next;
    }
    System.out.println();
  }

  public int getLast() {
    if(size == 0) {
      return -1;
    }
    return tail.data;
  }

  public int getFirst() {
    if(size == 0) {
      return -1;
    }
    return head.data;
  }

  public int removeFirst(){
    if(size == 0) {
      System.out.println("List is Empty.");
      return -1;
    } else if(size == 1) {
      int vl = head.data;
      head = tail = null;
      size--;
      return vl;
    } else {
      int vl = head.data;
      Node nbr = head.next;
      head.next = null;
      head = nbr;
      size--;
      return vl;
    }
  }

  public int removeLast(){
    if(size == 0) {
      System.out.println("List is Empty.");
      return -1;
    } else if(size == 1) {
      int vl = head.data;
      head = tail = null;
      size--;
      return vl;
    } else {
      Node ptr = head;
      while(ptr.next!=null && ptr.next.next!=null) {
        ptr = ptr.next;
      }
      int val = tail.data;
      ptr.next = null;
      tail = ptr;
      size--;
      return val;
    }
  }

  // 7 1 2 3 
  public int getAt(int idx) {
    if(idx < 0 || idx >=size) {
      System.out.println("Invalid index");
      return -1;
    } else if(idx == 0) {
      return getFirst();
    } else if(idx == size -1) {
      return getLast();
    } else {
      Node ptr = head;
      while(idx>0) {
        ptr = ptr.next;
        idx--;
      }
      return ptr.data;
    }
  }

  public int removeAt(int idx) {
    if(idx < 0 || idx >=size) {
      System.out.println("Invalid index");
      return -1;
    } else if(idx == 0) {
      return removeFirst();
    } else if(idx == size -1) {
      return removeLast();
    } else {
      Node ptr = head;
      Node prev = null;
      while(idx>0) {
        prev = ptr;
        ptr = ptr.next;
        idx--;
      }
      size--;
      int vl = ptr.data;
      prev.next = ptr.next;
      ptr.next = null;
      return vl;
    }
  }

  public void addAt(int idx,int val) {
    if(idx == 0) {
      addFirst(val);
    } else if(idx == size) {
      addLast(val);
    } else {
      Node ptr = head;
      Node prev = null;
      Node n = new Node();
      n.data = val;
      while(idx > 0) {
        prev = ptr;
        ptr = ptr.next;
        idx--;
      }
      n.next = ptr;
      prev.next = n;
      size++;
    }
  }
  }

  public static void main(String args[]) {
    LinkedList ll = new LinkedList();
    ll.addFirst(10);
    ll.addFirst(20);
    ll.addFirst(30);

    ll.addLast(40);
    ll.addLast(50);
    ll.addLast(60);
    ll.display();

    // ll.removeFirst();
    // ll.removeFirst();
    // ll.display();
    
    // ll.removeLast();
    // ll.display();

    // System.out.println(ll.getAt(5));

    // System.out.println(ll.removeAt(3));
    // ll.display();

    ll.addAt(6, 100);      
    ll.display();
  }
}
