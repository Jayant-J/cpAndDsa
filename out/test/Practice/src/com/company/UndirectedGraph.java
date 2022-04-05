package com.company;

import java.util.*;

public class UndirectedGraph {

    public static void bfs(int V, List<List<Integer>> adj) {
        boolean vis[] = new boolean[V + 1];
        List<Integer> bfs = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                vis[i] = true;

                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    bfs.add(node);
                    for (Integer it : adj.get(node)) {
                        if (vis[it] == false) {
                            vis[it] = true;
                            queue.offer(it);
                        }
                    }
                }
            }
        }
        System.out.println(bfs);
    }

    public static void dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> resDfs = new ArrayList<>();
        boolean[] vis = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!vis[i])
                dfs(i, vis, adj, resDfs);
        }
        System.out.println(resDfs);
    }

    public static void dfs(int i, boolean[] vis, List<List<Integer>> adj, List<Integer> resDfs) {
        resDfs.add(i);
        vis[i] = true;
        for (Integer it : adj.get(i)) {
            if (!vis[it])
                dfs(it, vis, adj, resDfs);
        }
    }

    public static boolean isCyclePresentBFS(int V, List<List<Integer>> adj) {
        boolean vis[] = new boolean[V + 1];
        Queue<PairNodePrev> queue = new LinkedList<>();
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                queue.offer(new PairNodePrev(i, -1));
                vis[i] = true;
                while (!queue.isEmpty()) {
                    PairNodePrev node = queue.poll();
                    for (Integer it : adj.get(node.node)) {
                        if (!vis[it]) {
                            vis[it] = true;
                            queue.offer(new PairNodePrev(it, node.node));
                        } else if (vis[it] && it != node.prev) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isCyclePresentDFS(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                return checkCycleDFS(i, -1, adj, vis);
            }
        }
        return false;
    }

    public static boolean checkCycleDFS(int node, int prev, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                return checkCycleDFS(it, node, adj, vis);
            } else if (vis[it] && it != prev) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkBipartiteBfs(int n, List<List<Integer>> adj) {
        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            color[i] = -1;
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    for (Integer it : adj.get(node)) {
                        if (color[it] == -1) {
                            color[it] = 1 - color[node];
                            queue.add(it);
                        } else if (color[it] == color[node])
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkBipartiteDfs(int n, List<List<Integer>> adj) {
        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            color[i] = -1;
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                return isBipartiteDfs(i, adj, color);
            }
        }
        return true;
    }

    public static boolean isBipartiteDfs(Integer node, List<List<Integer>> adj, int[] color) {
        if (color[node] == -1) {
            color[node] = 1;
        }
        for (Integer it : adj.get(node)) {
            if (color[it] == -1) {
                color[it] = 1 - color[node];
                return isBipartiteDfs(it, adj, color);
            } else if (color[it] == color[node])
                return false;
        }
        return true;
    }

    public static void shortestDistance(int src, int n, List<List<Integer>> adj) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        dist[src] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    queue.offer(it);
                }
            }
        }
        for (int it : dist)
            System.out.println(it + " ");
    }

    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= 5; i++)
            adjList.add(new ArrayList<>());

        addEdge(adjList, 1, 2);//        1------2
        addEdge(adjList, 1, 5);//        |    / | \
        addEdge(adjList, 2, 3);//        |   /  |  3
        addEdge(adjList, 2, 4);//        | /    | /
        addEdge(adjList, 2, 5);//        5------4
        addEdge(adjList, 3, 4);
        addEdge(adjList, 4, 5);

        List<List<Integer>> adjList2 = new ArrayList<>();
        for (int i = 0; i <= 3; i++)
            adjList2.add(new ArrayList<>());

        addEdge(adjList2, 1, 2);//        1------2------3
        addEdge(adjList2, 2, 3);

        System.out.println("BFS");
        bfs(5, adjList);
        System.out.println("DFS");
        dfsOfGraph(5, adjList);

        System.out.println("isCyclePresentBFS");
        System.out.println(isCyclePresentBFS(5, adjList));
        System.out.println(isCyclePresentBFS(3, adjList2));

        System.out.println("isCyclePresentDFS");
        System.out.println(isCyclePresentDFS(5, adjList));
        System.out.println(isCyclePresentDFS(3, adjList2));

        System.out.println("checkBipartiteBfs");
        System.out.println(checkBipartiteBfs(5, adjList));
        System.out.println(checkBipartiteBfs(3, adjList2));

        System.out.println("checkBipartiteDfs");
        System.out.println(checkBipartiteDfs(5, adjList));
        System.out.println(checkBipartiteDfs(3, adjList2));

    }
}

class PairNodePrev {
    Integer node;
    Integer prev;

    PairNodePrev(Integer node, Integer prev) {
        this.node = node;
        this.prev = prev;
    }
}