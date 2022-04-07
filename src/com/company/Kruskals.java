package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskals {

    static int n = 7;//no of nodes
    static int parent[] = new int[n + 1];
    static int rank[] = new int[n + 1];

    public static int getParent(int node) {
        if (parent[node] == node)
            return node;
        return parent[node] = getParent(parent[node]);
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

    static void kruskalsAlgo(List<NodeKruskal> adj) {
        Collections.sort(adj, new SortComparator());
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int mstCost=0;
        ArrayList<NodeKruskal> mst=new ArrayList<>();
        for (NodeKruskal it:adj){
            if(getParent(it.u)!=getParent(it.v)){
                mstCost+=it.wt;
                mst.add(it);
                union(it.u, it.v);
            }
        }
        System.out.println(mstCost);
        System.out.println(mst);
    }

    public static void main(String[] args) {
        ArrayList<NodeKruskal> adj = new ArrayList<>();
        adj.add(new NodeKruskal(1, 1, 4));
        adj.add(new NodeKruskal(2, 1, 2));
        adj.add(new NodeKruskal(3, 2, 3));
        adj.add(new NodeKruskal(3, 2, 4));
        adj.add(new NodeKruskal(4, 1, 5));
        adj.add(new NodeKruskal(5, 3, 4));
        adj.add(new NodeKruskal(7, 2, 6));
        adj.add(new NodeKruskal(8, 3, 6));
        adj.add(new NodeKruskal(9, 4, 5));
        kruskalsAlgo(adj);

    }
}

class SortComparator implements Comparator<NodeKruskal> {

    @Override
    public int compare(NodeKruskal n1, NodeKruskal n2) {
        if (n1.wt < n2.wt) {
            return -1;
        } else if (n1.wt > n2.wt) {
            return 1;
        }
        return 0;
    }
}

class NodeKruskal {
    int wt, u, v;

    NodeKruskal(int wt, int u, int v) {
        this.wt = wt;
        this.u = u;
        this.v = v;
    }
}
