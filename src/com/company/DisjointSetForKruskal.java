package com.company;

public class DisjointSetForKruskal {
    static int n=7;//no of nodes
    static int parent[]=new int[n+1];
    static int rank[]=new int[n+1];

    public static int getParent(int node){
        if(parent[node]==node)
            return node;
        return parent[node]=getParent(parent[node]);
    }
    public static void union(int u, int v){
        u=getParent(u);
        v=getParent(v);
        if(rank[u]< rank[v]){
            parent[u]=v;
        }else if(rank[u]> rank[v]){
            parent[v]=u;
        }else{
            parent[v]=u;
            rank[u]++;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        union(1, 2);
        union(2, 3);
        union(4, 5);
        union(6, 7);
        union(5, 6);
        union(3, 7);
    }
}
