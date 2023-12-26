import java.util.*;
import java.io.*;

public class Main{
    static class Edge{
        int src,nbr,wt;
        Edge(int s,int n,int w){
            src = s;
            nbr = n;
            wt = w;
        }

        public String toString() {
            return this.src+" "+this.nbr+" "+this.wt;
        }
    }

    static class Pair implements Comparable<Pair>{
        int vtx,wsf;
        String psf;
        Pair(int vtx,int wsf,String psf){
            this.vtx = vtx;
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf; // min-priority
            // return o.wsf - this.wsf; // max-priority
        }
    }

    static void printShortestWeightedPath(LinkedList<Edge>[] graph,int src){
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       boolean visited[] = new boolean[graph.length];
       pq.add(new Pair(src,0,src+""));
       System.out.println(Arrays.toString(graph));
       while(pq.size()>0) {
           Pair pair = pq.remove();
        //    System.out.println("okoko");
        if(visited[pair.vtx]) continue;
        visited[pair.vtx] = true;
        System.out.println(pair.vtx+" @ "+pair.psf+" # "+pair.wsf);
        for(Edge vtx:graph[pair.vtx]) {
          if(visited[vtx.nbr] == false) {
            // System.out.println("okkoko");
            pq.add(new Pair(vtx.nbr, vtx.wt+pair.wsf, pair.psf+vtx.nbr));
          }
        }
       }
    }


    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vtces = Integer.parseInt(br.readLine());
        LinkedList<Edge>[] graph = new LinkedList[vtces];
        
        for(int i = 0 ; i < vtces ; i++){
            graph[i] = new LinkedList();
        }
        
        int Edges = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < Edges ; i++){
            String[] input = br.readLine().split(" ");
            int vtx1 = Integer.parseInt(input[0]);
            int vtx2 = Integer.parseInt(input[1]);
            int wt = Integer.parseInt(input[2]);

            graph[vtx1].add(new Edge(vtx1,vtx2,wt));
            graph[vtx2].add(new Edge(vtx2,vtx1,wt));
        }

        for(int i=0;i<graph.length;i++) {

        }

        printShortestWeightedPath(graph,0);

    }
}

/*
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 5 
4 5 3 
5 6 3 
4 6 7 
 */