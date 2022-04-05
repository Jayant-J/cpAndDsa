package com.company;

import java.util.ArrayList;

public class MST {

    public static void mstUsingPrims(ArrayList<ArrayList<Node>> adj, int n) {
        int[] key = new int[n];
        boolean[] mst = new boolean[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mst[i] = false;
        }
        //0 -> src
        key[0] = 0;
        mst[0] = true;
        for (int i = 0; i < n - 1; i++) {
            int mini = Integer.MAX_VALUE, u = 0;
            for (int v = 0; v < n; v++) {
                if (!mst[v] && key[v] < mini) {
                    mini = key[v];
                    u = v;
                }
            }
            mst[u] = true;
            for (Node it : adj.get(u)) {
                if (!mst[it.getV()] && it.getV() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getV();
                }
            }
        }

        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }

    public static void mstUsingKrukals(ArrayList<ArrayList<Node>> adj, int n) {

    }

    public static void main(String args[]) {
        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));
        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));
        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));
        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));
        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));
        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));

        mstUsingPrims(adj, n);
        mstUsingKrukals(adj, n);

    }
}
