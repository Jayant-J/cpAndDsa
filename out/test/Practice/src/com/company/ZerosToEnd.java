package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZerosToEnd {
    public static void main(String[] args) {
        List<Integer> l=new ArrayList<>();
        l.addAll(Arrays.asList(5,6,0,7,0,1,11));
        int arr[]={5,6,0,7,0,1,11};
        int j=l.size()-1;
        int i =0;
        while(i<=j){
//            if(l.get(i)==0){
//                int temp=l.get(j);
//                l.remove(i);
//                l.add(i,temp);
//                l.remove(j);
//                l.add(j, 0);
//            }
            if(arr[i]==0){
                arr[i]=arr[j];
                arr[j]=0;
                i++;
                j--;
            }
            else
            i++;
        }
        System.out.println("sorted");
        for(int ii :arr){
            System.out.println(ii);
        }
    }
}
