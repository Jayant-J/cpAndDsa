package com.company;

import java.util.HashMap;
import java.util.Map;

public class DistributeCandies {
    public static int distributeCandies(int[] candyType) {
        HashMap<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<candyType.length;i++){
            if(m.containsKey(candyType[i]))
                continue;
            else
                m.put(candyType[i], 1);
        }
        if(candyType.length/2==0)
            return(Math.min(candyType.length/2, m.size()));
        else
            return(Math.min(candyType.length/2-1, m.size()));
    }
    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1,1,2,2,3,3}));
    }
}
