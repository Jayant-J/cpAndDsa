package com.company;

import java.util.ArrayList;
import java.util.List;

public class AllUniqueSubSet {

    static int[] arr={1,1,1,2,2};
    static int n=5;

    static void getAllUniqueSubSet(int ind, List<Integer> list){
        if(ind==n){
            System.out.println(list);
        }

        for(int i=ind;i<arr.length; i++){
            if(i>ind && arr[i]==arr[i-1])
                continue;
            list.add(arr[i]);
            getAllUniqueSubSet(i+1, list);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        getAllUniqueSubSet(0, list);
    }
}
