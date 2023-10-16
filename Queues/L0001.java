import java.util.Queue;
import java.util.ArrayDeque;
public class L0001 {
 public static void main(String args[]) {
  // Queue<Integer> queue = new ArrayDeque<>();
  // System.out.println(queue);

  // queue.add(10);
  // System.out.println(queue.size() + " " + queue.peek());

  // queue.add(20);
  // System.out.println(queue.size() + " "  + queue.peek());

  // queue.add(30);
  // System.out.println(queue.size() + " "  + queue.peek());

  // queue.add(40);
  // System.out.println(queue.size() + " "  + queue.peek());

  // while(queue.size() > 0){
  //   System.out.print(queue.remove() + " -> ");
  // }

  ImplementQueue queue = new ImplementQueue(5);
  System.out.println(queue);

  queue.add(10);
  System.out.println(queue.size() + " " + queue.peek());

  queue.add(20);
  System.out.println(queue.size() + " "  + queue.peek());

  queue.add(30);
  System.out.println(queue.size() + " "  + queue.peek());

  queue.add(40);
  System.out.println(queue.size() + " "  + queue.peek());

  queue.add(50);
  System.out.println(queue.size() + " "  + queue.peek());
  
  queue.remove();
  queue.remove();

  queue.add(60);
  System.out.println(queue.size() + " "  + queue.peek());

  
  queue.add(70);
  System.out.println(queue.size() + " "  + queue.peek());

  System.out.println("removed " + queue.size() + queue.front);

  queue.add(80);
  queue.add(90);

  System.out.println(queue.size() + " "  + queue.peek());

  while(queue.size() > 0){
    System.out.print(queue.remove() + " -> ");
  }
 } 

 public static class ImplementQueue {
  int data[];
  int front;
  int size;

  ImplementQueue(int cap) {
    data = new int[cap];
    size = 0;
    front = 0;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size(){
    return size;
  }

  public void add(int val){
    // System.out.println(val+" val");
    if(size == data.length) {
      // make new arr if overflow
      int newArr[] = new int[data.length*2];
      int index = 0;

      // copy the all data
      // 1.
      // for(int i=front;i<data.length;i++) {
      //   newArr[index++] = data[i];
      // }
      // for(int i=0;i<front;i++) {
      //   newArr[index++] = data[i];
      // }

      // 2.
    for(int i=0;i<front;i++) {
          newArr[index++] = data[i];
        }

      // copy new address in old data
      data = newArr;

      // modifying front to follow fifo behaviour
      front = 0;
    }
    int idx = (front + size) % data.length;
    data[idx] = val;
    size++;
  }

  public int remove(){
    if(size == 0) {
      System.out.println("Queue Underflow");
      return -1;
    }
    int val = data[front];
    front = (front + 1) % data.length;
    size--;
    return val;
  }

  public int peek(){
    return size==0 ? -1 : data[front];
  }

 }
}
