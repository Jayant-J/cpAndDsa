package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MST {

    public static void mstUsingPrimsBrute(ArrayList<ArrayList<Node>> adj, int n) {
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

    public static void mstUsingPrimsEff(ArrayList<ArrayList<Node>> adj, int n) {
        int[] key = new int[n];
        boolean[] mst = new boolean[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mst[i] = false;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //0 -> src
        pq.add(new Node(0, key[0]));
        key[0] = 0;
        mst[0] = true;
        for (int i = 0; i < n - 1; i++) {
            int u = pq.poll().getV();
            mst[u] = true;
            for (Node it : adj.get(u)) {
                if (!mst[it.getV()] && it.getV() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getV();
                    pq.add(new Node(it.getV(), key[it.getV()]));
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

        mstUsingPrimsBrute(adj, n);
        mstUsingPrimsEff(adj, n);
        mstUsingKrukals(adj, n);

    }
}

class Node implements Comparator<Node>
{
    private int v;
    private int weight;

    Node(int _v, int _w) { v = _v; weight = _w; }

    int getV() { return v; }
    int getWeight() { return weight; }

    @Override
    public int compare(Node node1, Node node2)
    {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}
