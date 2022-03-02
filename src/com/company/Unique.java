package com.company;

public class Unique {
    public static void main(String[] args) {
        int[] a2={4,4,5,5,2,0,0,6,6,7,7};
         int dist=a2[0];
         for (int i=1;i<a2.length;i++){
           dist=dist^a2[i];
         }
         System.out.println(dist);

    }
}
