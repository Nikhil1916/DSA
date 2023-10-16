import java.util.PriorityQueue;
import java.util.*;

public class L0001{
    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        System.out.println(pq);

        pq.add(10);
        System.out.println(pq+" highest priority ele : "+pq.peek());
        pq.add(-1);
        System.out.println(pq+" highest priority ele : "+pq.peek());
        pq.add(23);
        System.out.println(pq+" highest priority ele : "+pq.peek());
        pq.add(40);
        System.out.println(pq+" highest priority ele : "+pq.peek());
        pq.add(10);
        System.out.println(pq+" highest priority ele : "+pq.peek());
        pq.add(-2);
        System.out.println(pq+" highest priority ele : "+pq.peek());
        pq.add(98);
        System.out.println(pq+" highest priority ele : "+pq.peek());
        pq.add(101);
        System.out.println(pq+" highest priority ele : "+pq.peek());
        pq.add(11);
        System.out.println(pq+" highest priority ele : "+pq.peek());
        pq.add(-8);
        System.out.println(pq+" highest priority ele : "+pq.peek());

        while(pq.size() > 0){
            System.out.print(pq.remove()+" -> ");
        }

        System.out.println(".");    
    }
}