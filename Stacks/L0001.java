// import java.util.Stack;

public  class L0001{ 
  public static void main(String args[]) {
    // Stack<Integer> st = new Stack<>();
    ImplementStack st = new ImplementStack(5);
    // System.out.println(st);

    st.peek();
    st.pop();
    st.push(10);
    System.out.println(st + " " + st.peek() + " " + st.size());
    
    st.push(20);
    System.out.println(st + " " + st.peek() + " " + st.size());
    
    st.push(30);
    System.out.println(st + " " + st.peek() + " " + st.size());
    
    st.push(40);
    System.out.println(st + " " + st.peek() + " " + st.size());

    st.pop();
    System.out.println(st + " " + st.peek() + " " + st.size());

    st.push(50);
    System.out.println(st + " " + st.peek() + " " + st.size());

    st.push(60);
    System.out.println(st + " " + st.peek() + " " + st.size());

    st.push(70);
    st.push(80);
    
    st.push(90);
    st.push(100);

    System.out.println(st + " " + st.peek() + " " + st.size());    
    st.pop();
    System.out.println(st + " " + st.peek() + " " + st.size());

    
    // System.out.println(st + " " + st.peek() + " " + st.size());

    while(st.size() > 0) {
      System.out.println(st.peek());
      st.pop();
    }
  }

  public static class ImplementStack {
    int data[];
    int top = -1;
    ImplementStack(int cap) {
      data = new int[cap];
      top = -1;
    }

    public void push(int val) {
      if(size() == data.length) {
        // if size full then double the array
        int newArr[] = new int[data.length*2];

        // copying old data
        for(int i=0;i<data.length;i++) {
          newArr[i] = data[i];
        }
        // copying the new Arr address in data[] as all operations r done on it 
        data = newArr;
      }
      top++;
      data[top] = val;
    }

    public int pop() {
      if(isEmpty()) {
        System.out.println("Stack Underflow");
        return -1;
      }
      int val = data[top];
      top--;
      return val;
    }


    public int size() {
      return top + 1;
    }

    public int peek() {
      if(isEmpty()) {
        System.out.println("Stack Underflow");
        return -1;
      }
      int val = data[top];
      return val;
    }

    public boolean isEmpty() {
      return size() == 0;
    }
  }
}