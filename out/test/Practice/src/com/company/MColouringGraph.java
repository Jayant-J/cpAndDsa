package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//DOUBT

public class MColouringGraph {

    public static boolean isSafe(int node, List<List<Integer>> G, int[]color, int n, int col){
        for(int i:G.get(node)){
            if(color[i]==col)
                return false;
        }
        return true;
    }
    public static boolean solve(int node, List<List<Integer>> G, int[] color, int n, int m){
        if(node==n)
            return true;
        for(int i=0;i<=m;i++){
            if(isSafe(node, G, color, n, i)){
                color[node]=i;
                if(solve(node+1, G, color, n, m)==true)
                    return true;
                color[node]=0;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<List<Integer>> G=new ArrayList<>();
        G.add(Arrays.asList(3,1,2));
        G.add(Arrays.asList(0,2,3));
        G.add(Arrays.asList(1,0));
        G.add(Arrays.asList(1,0));
        int n=G.size();                                     //      0----3
        int m=5;                                            //      | \ |
        int color[]=new int[n];                             //     2---1
        if(solve(0, G, color, n, m)==true)           //
            System.out.println("true");

    }
}

