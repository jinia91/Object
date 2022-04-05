import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Sol {

    static int[] parent;
    static int answer;

    public static void main(String[] args) {
        int[][] cost = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int n = 4;

        parent = new int[n];
        for(int i =0; i<n; i++){
            parent[i] = i;
        }

        List<Edge> list = new ArrayList<>();
        for (int[] edgeArr : cost) {
            list.add(new Edge(edgeArr));
        }
        Collections.sort(list);

        for (Edge edge : list) {
           answer += union(edge);
        }

    }

    static int union(Edge edge){
        int x = find(edge.nodeA);
        int y = find(edge.nodeB);

        if(x==y) return 0;

        if(x>y) parent[x] = y;
        else parent[y] = x;
        return edge.cost;
    }

    static int find(int x){
        if(x == parent[x]) {
            return x;
        }
        else return parent[x] = find(parent[x]);
    }

    static class Edge implements Comparable<Edge>{
        int nodeA;
        int nodeB;
        int cost;

        public Edge(int[] edgeArr) {
            this.nodeA = edgeArr[0];
            this.nodeB = edgeArr[1];
            this.cost = edgeArr[2];
        }

        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
