package com.company;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static int[] arr=new int[]{3,1,2};
    static int n=3;
    public static void getAll(int ind, List<Integer> l){
        if(ind>=n){
            System.out.println(l);
            return;
        }
        l.add(arr[ind]);
        getAll(ind+1, l);
        l.remove(l.size()-1);
        getAll(ind+1, l);
    }

    public static void main(String[] args) {
        List<Integer> l=new ArrayList<>();
        getAll(0, l);
    }
}

