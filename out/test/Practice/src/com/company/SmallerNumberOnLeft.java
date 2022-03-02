package com.company;

import java.util.HashMap;
import java.util.Map;

public class SmallerNumberOnLeft {
    public static int[] count;
    public static void main(String[] args) {
        int[] arr={8, 5, 11, -1, 3, 4, 2};
        count=new int[arr.length];
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(i, i);
            count[i]=0;
        }
        mergeSort(arr, map, 0, arr.length-1);
        for (int i:count){
            System.out.print(i+" ");
        }
    }
    public static void mergeSort(int[] arr, Map<Integer, Integer> map, int l, int r){
        if(l<r){
            int mid=(l+r)/2;
            mergeSort(arr, map, l, mid);
            mergeSort(arr, map, mid+1, r);
            merge(arr, map, l, mid, r);
        }
    }
    public static void merge(int[] arr, Map<Integer, Integer> map, int l, int mid, int r){
        int lSize=mid-l+1;
        int rSize=r-mid;
        int[] lArr=new int[lSize];
        int[] rArr=new int[rSize];
        for(int i=0;i<lSize;i++){
            lArr[i]=map.get(l+i);
        }
        for(int i=0;i<rSize;i++){
            rArr[i]=map.get(i+mid+1);
        }
        int i=0, j=0, k=l, rightCount=0;
        while(i<lArr.length && j<rArr.length){
            if(arr[lArr[i]]<=arr[rArr[j]]){
                map.put(k, lArr[i]);
                count[lArr[i]]+=rightCount;
                i++;
            } else{
                map.put(j, rArr[j]);
                rightCount++;
                j++;
            }
            k++;
        }
        while(i<lSize){
            map.put(k, lArr[i]);
            count[lArr[i]]+=rightCount;
            i++;
            k++;
        }
        while(j<rSize){
            map.put(k, rArr[j]);
            j++;
            k++;
        }
    }
}
