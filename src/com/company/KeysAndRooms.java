package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {

    public static void current(List<Integer> keys, int[] visited){
        for (int j=0;j<keys.size();j++)
            visited[keys.get(j)]=1;
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        int visited[]=new int[n];
        Arrays.fill(visited,-1);
        System.out.println(n);
        visited[0]=1;
        for(int i=0;i<n;i++){
            if(visited[i]==1)
                current(rooms.get(i), visited);
        }
        if(Arrays.asList(visited).contains(-1))
            return true;
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(3);
        rooms.add(l);
        l.clear();
        l.add(3);
        l.add(0);
        l.add(1);
        rooms.add(l);
        l.clear();
        l.add(2);
        rooms.add(l);
        l.clear();
        l.add(0);
        rooms.add(l);
        l.clear();
        System.out.println(canVisitAllRooms(rooms));
    }
}