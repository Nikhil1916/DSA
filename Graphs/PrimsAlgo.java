import java.util.*;
import java.io.*;

public class PrimsAlgo{
    static class Edge {
        int src,nbr,wt;
        Edge(int s,int n,int w){
            src = s;
            nbr = n;
            wt = w;
        }
    }

    static class Pair implements Comparable<Pair>{
        int vtx,pvtx,wt;
        Pair(int vtx,int wt,int pvtx){
            this.vtx = vtx;
            this.wt = wt;
            this.pvtx = pvtx;
        }

        public int compareTo(Pair o){
            return this.wt-o.wt;
        }
    }

    static void findMST(LinkedList<Edge>[] graph){
      Integer[] visited = new Integer[graph.length];
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(1, 0, -1));
      while(!pq.isEmpty()) {
        Pair pair = pq.remove();
        if(visited[pair. vtx] == null) {
          if(pair.pvtx !=-1) {
            System.out.println(pair.pvtx + " - " + pair.vtx + " @ " + pair.wt);
          }
          visited[pair.vtx] = pair.pvtx;
          for(Edge vertex: graph[pair.vtx]) {
            if(visited[vertex.nbr]==null) {
              pq.add(new Pair(vertex.nbr, vertex.wt, vertex.src));
            } 
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

        findMST(graph);
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
4 5 6
5 6 3
4 6 7
*/