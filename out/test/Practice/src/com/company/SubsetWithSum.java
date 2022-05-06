package com.company;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithSum {

    static int[] arr= new int[]{3,1,2};
    static int n=3;
    public static void getSubSetSum(int ind, List<Integer> list, int sum){
        if(ind>=n){
            System.out.println(list+" : "+sum);
            return;
        }
        list.add(arr[ind]);
        sum+=arr[ind];
        getSubSetSum(ind+1, list, sum);
        list.remove(list.size()-1);
//        sum-=arr[ind];
        getSubSetSum(ind+1, list, sum-arr[ind]);

    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        getSubSetSum(0, list, 0);
    }
}

