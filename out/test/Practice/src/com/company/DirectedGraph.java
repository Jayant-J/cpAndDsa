package com.company;

import java.util.*;

public class DirectedGraph {

    public static boolean isCycleDFS(int n, List<List<Integer>> adj){
        boolean vis[]=new boolean[n+1];
        boolean dfsVis[]=new boolean[n+1];
        for(int i=1;i<=n;i++) {
            if(!vis[i]){
                if(checkDfs(i, adj, vis, dfsVis)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkDfs(int node, List<List<Integer>> adj, boolean vis[], boolean dfsVis[]){
        vis[node]=true;
        dfsVis[node]=true;
        for(int it: adj.get(node)){
            if(!vis[it]){
                if(checkDfs(it, adj, vis, dfsVis)){
                    return true;
                }
            } else if(dfsVis[it]){
                return true;
            }
        }
        dfsVis[node]=false;
        return false;
    }

    public static void topoSortUsingDFS(int n, List<List<Integer>> adj){
        boolean[] vis=new boolean[n+1];
        Stack<Integer> stk=new Stack<>();
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                findtopoForDFS(i, adj, vis, stk);
            }
        }
        System.out.println(stk);
    }
    public static void findtopoForDFS(int node, List<List<Integer>> adj, boolean[] vis, Stack<Integer> stk){
        vis[node]=true;
        for(int it: adj.get(node)){
            if(!vis[it])
                findtopoForDFS(it, adj, vis, stk);
        }
        stk.push(node);
    }

    //    Kahn's Algo
    public static void topoSortUsingBFS(int n, List<List<Integer>> adj){
        int[] inDegree=new int[n+1];
        int[] topoSort=new int[n+1];
//        get InDergree
        for(int i=1;i<=n;i++){
            for(int it:adj.get(i))
                inDegree[it]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=n;i++) {
            if (inDegree[i]==0)
                queue.offer(i);
        }
        int ind=0;
        int cnt=0;
        while(!queue.isEmpty()){
            int node= queue.poll();
            cnt++;
            topoSort[ind++]=node;
            for(int it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0)
                    queue.offer(it);
            }
        }
        if(cnt==n)
            System.out.println("isNotCyclic");
        else
            System.out.println("isCyclic");
        for(int it:topoSort)
            System.out.print(it+" ");
    }

    public static void shortestPathDAG(int src, List<List<PairWeight>> adj, int n) {
        Stack<Integer> stk = new Stack<>();
        int[] dist = new int[n];
        for (int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i])
                getTopoSort(i, vis, stk, adj);
        }
        while (stk.empty() == false) {
            int node=stk.pop();
            if(dist[node]!=Integer.MAX_VALUE){
                for(PairWeight it:adj.get(node)){
                    if(dist[node]+it.wt<dist[it.v]){
                        dist[it.v]=dist[node]+it.wt;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE)
                System.out.print("-1 ");
            else
                System.out.print(dist[i]+" ");
        }
    }
    public static void getTopoSort(int node, boolean[] vis, Stack<Integer> stk, List<List<PairWeight>> adj) {
        vis[node] = true;
        for (PairWeight it : adj.get(node)) {
            if (vis[it.v] == false)
                getTopoSort(it.v, vis, stk, adj);
        }
        stk.push(node);
    }


    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= 5; i++)
            adjList.add(new ArrayList<>());
        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(5).add(1);//        1------>2
        adjList.get(5).add(2);//        /\   /\ /\ \>
        adjList.get(5).add(4);//        |   /   |    3
        adjList.get(4).add(2);//        | /     |  />
        adjList.get(4).add(3);//        5----->4

        List<List<Integer>> adjList2 = new ArrayList<>();
        for (int i = 0; i <= 5; i++)
            adjList2.add(new ArrayList<>());
        adjList2.get(1).add(2);
        adjList2.get(2).add(3);
        adjList2.get(5).add(1);//        1------>2
        adjList2.get(5).add(2);//        /\   /\ /\ \>
        adjList2.get(5).add(4);//        |   /   |    3
        adjList2.get(4).add(2);//        | /     | </
        adjList2.get(3).add(4);//        5----->4

        System.out.println("isCycleDFS");
        System.out.println(isCycleDFS(5, adjList));
        System.out.println(isCycleDFS(5, adjList2));

        System.out.println("topoSortDFS");
        topoSortUsingDFS(5, adjList);

        System.out.println("topoSortBFS");
        topoSortUsingBFS(5, adjList);
        System.out.println();
        topoSortUsingBFS(5, adjList2);

        List<List<PairWeight>> adjDAG = new ArrayList<>();

        for (int i = 0; i < 6; i++)
            adjDAG.add(new ArrayList<>());

        adjDAG.get(0).add(new PairWeight(1, 2));
        adjDAG.get(0).add(new PairWeight(4, 1));
        adjDAG.get(1).add(new PairWeight(2, 3));
        adjDAG.get(2).add(new PairWeight(3, 6));
        adjDAG.get(4).add(new PairWeight(2, 2));
        adjDAG.get(4).add(new PairWeight(5, 4));
        adjDAG.get(5).add(new PairWeight(3, 1));
        System.out.println("\nshortestPathDAG");
        shortestPathDAG(0, adjDAG, 6);
    }
}

class PairWeight {
    Integer v;
    Integer wt;

    PairWeight(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}
