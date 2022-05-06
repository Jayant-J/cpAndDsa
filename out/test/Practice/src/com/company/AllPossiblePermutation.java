package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossiblePermutation {
    static int arr[]=new int[]{1,2,3};
    static int n=3;
    public static void getAllPossiblePermutation(List<Integer> list, Map<Integer, Boolean> map){
        if(list.size()==n){
            System.out.println(list);
            return;
        }
        for (int i=0;i<arr.length; i++){
            if(!map.get(arr[i])) {
                list.add(arr[i]);
                map.put(arr[i], true);
                getAllPossiblePermutation(list, map);
                list.remove(list.size()-1);
                map.put(arr[i], false);
            }
        }
    }
    public static void swap(int i, int j, int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void getAllPossiblePermutationSwapApproach(int ind){
        if(ind==n){
            for (int i:arr)
                System.out.print(i+" ");
            System.out.println();
            return;
        }
        for(int i=ind;i<arr.length;i++){
            swap(i, ind, arr);
            getAllPossiblePermutationSwapApproach(ind+1);
            swap(i, ind, arr);
        }
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Map<Integer, Boolean> visited=new HashMap<>();
        for (int i:arr)
            visited.put(i, false);
//        getAllPossiblePermutation(list, visited);
        getAllPossiblePermutationSwapApproach(0);
    }
}

