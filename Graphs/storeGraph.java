import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class storeGraph {
  

  static class Edge {
    int src,nbr,wt;
    Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
      this.wt= wt;
    }

    public String toString() {
      return "["+src+" -> "+nbr+"]";
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int nv = sc.nextInt();
    int ne = sc.nextInt();
    // int [][] graph = buildAdjacencyMatrix(nv, ne, sc);
    // for(int i=0;i<graph.length;i++) {
    //   for(int j=0;j<graph[i].length;j++) {
    //     System.out.print(graph[i][j]+" ");
    //   }
    //   System.out.println();
    // }

    LinkedList<Edge>[] graph = buildAdjacencyList(nv, ne, sc);
    System.out.println(Arrays.toString(graph));
    // dfs(graph,0);
      // System.out.println(hasPathExist(graph, 3, 4));
      // printAllPaths(graph, 0, 5);.
      // System.out.println(gcc(graph));
      printInBFSOrder(graph, 2);
  }

  public static int[][] buildAdjacencyMatrix(int nv, int ne, Scanner sc) {
    int mat[][] = new int[nv][nv];
    while(ne>0) {
      int src = sc.nextInt(), dest = sc.nextInt();
      mat[src][dest] = 1;
      ne--;
    }
    return mat;
  }


      static HashMap<Integer,HashSet<Edge>> buildMap(int nv,int ne,Scanner scn){
        HashMap<Integer,HashSet<Edge>> map = new HashMap<>();

        while(ne > 0){
            int src = scn.nextInt() , nbr = scn.nextInt();
            
            if(!map.containsKey(src)){
                map.put(src,new HashSet<>());
            }

            map.get(src).add(new Edge(src,nbr));

            ne--;
        }

        return map;
    }

    static LinkedList<Edge>[] buildAdjacencyList(int nv,int ne,Scanner scn){
        LinkedList<Edge>[] list = new LinkedList[nv];
        
        for(int i = 0 ; i < nv ; i++){
            list[i] = new LinkedList<Edge>();
        }

        while(ne > 0){
            int src = scn.nextInt() , nbr = scn.nextInt();
            list[src].addLast(new Edge(src,nbr));
            ne--;
        }

        return list;
    }

    static void dfs(LinkedList<Edge>[] graph, int src) {
      int nvtx = graph.length;
      boolean[] visited = new boolean[nvtx];
      dfsHelper(graph, src, visited);
    }

    static void dfsHelper(LinkedList<Edge>[] graph, int currVrtex, boolean visited[]) {
      visited[currVrtex] = true;
      System.out.println(currVrtex);
      for(Edge edge:graph[currVrtex]) {
        if(visited[edge.nbr]==false) {
          dfsHelper(graph,edge.nbr,visited);
        }
      }
    }


    // check path exist

    // v1 -> current vertex v2-> target vertex
    static boolean hasPathExist(LinkedList<Edge> graph[], int v1, int v2) {
      boolean visited[] = new boolean[graph.length];
      if(v1<0 || v1>=graph.length || v2<0 || v2>=graph.length) return false;
      return hasPathExistHelper(graph, v1, v2 , visited);
    }

    static boolean hasPathExistHelper(LinkedList<Edge> graph[], int v1, int v2, boolean visited[]) {
      if(v1 == v2) return true;
      visited[v1] = true;
      for(Edge vertex:graph[v1]) {
        if(visited[vertex.nbr] == false) {
          boolean pathExist = hasPathExistHelper(graph, vertex.nbr, v2, visited);
          if(pathExist) return true;
        }
      }
      return false;
    }

    
    // v1 -> current vertex or source v2-> target vertex or destination
    static void printAllPaths(LinkedList<Edge> graph[], int v1, int v2) {
      boolean visited[] = new boolean[graph.length];
      if(v1<0 || v1>=graph.length || v2<0 || v2>=graph.length) return;
      printAllPathsHelper(graph, v1, v2 , visited, v1+" -> ");
    }

    static void printAllPathsHelper(LinkedList<Edge> graph[], int v1, int v2, boolean visited[], String pathSoFar) {
      if(v1 == v2) {
        System.out.println(pathSoFar);
        return;
      }
      visited[v1] = true;
      for(Edge vertex:graph[v1]) {
        if(visited[vertex.nbr] == false) {
          printAllPathsHelper(graph, vertex.nbr, v2, visited, pathSoFar+vertex.nbr+" -> ");
        }
      }
      visited[v1] = false;
    }

    // get connected components
    public static ArrayList<ArrayList<Integer>> gcc(LinkedList<Edge> graph[]) {
      boolean visited[] = new boolean[graph.length];
      ArrayList<ArrayList<Integer>> mainAns = new ArrayList<>();
      for(int i=0;i<graph.length;i++) {
        if(visited[i] == false) {
          ArrayList<Integer> componentVtxList  = new ArrayList<>();
          dfsTravelAndCollectVtx(graph, i, componentVtxList, visited);
          mainAns.add(componentVtxList);
        }
      }
      return mainAns;
    } 
    public static void dfsTravelAndCollectVtx(LinkedList<Edge> graph[], int src, ArrayList<Integer>list, boolean[] visited) {
      visited[src] = true;
      list.add(src);
      for(Edge vertex:graph[src]) {
        if(visited[vertex.nbr] == false) {
          dfsTravelAndCollectVtx(graph, vertex.nbr, list, visited);
        }
      }
    }


    // BFS
    public static class Pair{
      int vtx;
      String psf;

      Pair(int vtx,String psf){
          this.vtx = vtx;
          this.psf = psf;
      }
  }
  public static void printInBFSOrder(LinkedList<Edge>[] graph,int src){
    Queue<Pair> qu = new ArrayDeque<>();
    boolean visited[] = new boolean[graph.length];
    qu.add(new Pair(src, src+""));  
    while(qu.size()>0) {
      Pair top = qu.remove();
      if(visited[top.vtx] == true) continue;
      visited[top.vtx] = true;
      System.out.println(top.vtx+" @ "+top.psf);
      for(Edge vertex:graph[top.vtx]) {
        if(visited[vertex.nbr] == false) {
          qu.add(new Pair(vertex.nbr, top.psf+vertex.nbr));
        }
      }
    }
  }


  // check whether gcc required as Forest graph can also come.
  public static boolean isCyclic(LinkedList<Edge>[] graph,int src){
    Queue<Pair> qu = new ArrayDeque<>();
    boolean visited[] = new boolean[graph.length];
    qu.add(new Pair(src, src+""));  
    while(qu.size()>0) {
      Pair top = qu.remove();
      if(visited[top.vtx] == true) return true;
      visited[top.vtx] = true;
      System.out.println(top.vtx+" @ "+top.psf);
      for(Edge vertex:graph[top.vtx]) {
        if(visited[vertex.nbr] == false) {
          qu.add(new Pair(vertex.nbr, top.psf+vertex.nbr));
        }
      }
    }
    return false;
  }


  public static class BipartitePair {
    boolean isVisited;
    char group;
    int vtx;
    // is visited not needed vaise
    BipartitePair(int vtx, boolean isVisited, char group) {
      this.vtx = vtx;
      this.isVisited = isVisited;
      this.group = group;
    }
    BipartitePair(int vtx) {
      this.vtx = vtx;
      isVisited = false;
      group = 'A';
    }
  }

  public static boolean isBipartite(LinkedList<Integer> graph[]) {
    int src = 0;
    Queue<BipartitePair> q = new ArrayDeque<>();
    BipartitePair arr[] = new BipartitePair[graph.length];
    q.add(new BipartitePair(src));
    while(q.size() > 0) {
      BipartitePair pair = q.remove();
      // arr[src] = 
      if(arr[src].isVisited) {
        if(arr[src].group != pair.group) {
          return false;
        }
      } else {
        arr[src] = pair;
      }

    }

    return true;
  }

  // 26/11

// dijkstra's algorithm
static class WeightedPair implements Comparable<WeightedPair>{
        int vtx,wsf;
        String psf;
        WwightedPair(int vtx,int wsf,String psf){
            this.vtx = vtx;
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(WeightedPair o) {
          return this.wsf - o.wsf;// min-priority
          return o.wsf - this.wsf;//max priority
        }
    }

    static void printShortestWeightedPath(LinkedList<Edge>[] graph,int src){
        PriorityQueue<WeightedPair> pq = new PriorityQueue<WeightedPair>();
        boolean[] visited = new boolean[graph.length];
        pq.add(new WeightedPair(src, 0,src+""));
        while(pq.size() > 0) {
          WeightedPair top = pq.remove();
          if(visited[top.vtx]) continue;
          System.out.println(top.vtx+" @ "+top.psf+" # "+top.wsf);
          for(Edge vtx:graph[src]) {
            if(visited[vtx.nbr] == false) {
              pq.add(vtx.nbr, top.wsf + vtx.wt, top.psf+vtx.nbr+"");
            }
          }
        }
    }
}






// input
/*
5
8
0 1
1 0
1 2
4 1
2 4
4 2
3 2 
2 3
 */


//  dfs
/*
5
10
0 3
3 0
0 1
1 0
1 4
4 1
4 2
2 4
1 2
2 1
*/


// has path
/*
7
16
0 3
3 0
0 1
1 0
1 2
2 1
2 3 
3 2
3 4
4 3
4 5
5 4
5 6
6 5
4 6
6 4
 */

 // has path 2 false case 3-4
/*
7
14
0 3
3 0
0 1
1 0
1 2
2 1
2 3 
3 2
4 5
5 4
5 6
6 5
4 6
6 4
 */

 /*
9
16
0 1
1 0
1 2
2 1
2 3
3 2
0 3
3 0
4 5
5 4
4 6
6 4
5 6
6 5
7 8
8 7
*/