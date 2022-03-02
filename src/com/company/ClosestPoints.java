package com.company;

import java.util.Arrays;

public class ClosestPoints {
    public static void main(String[] args) {
        int points[][]={{3,3},{5,-1},{-2,4}};
        int k=2;
        int dist[]=new int[points.length];
        for(int i=0;i<points.length;i++){
            dist[i]=(points[i][0]*points[i][0])+(points[i][1]*points[i][1]);
        }
        Arrays.sort(dist);
        int distk=dist[k-1];
        for(int i=0;i<points.length;i++){
            int d=(points[i][0]*points[i][0])+(points[i][1]*points[i][1]);
            if(d<=distk){
                System.out.println(points[i][0]+" "+points[i][1]);
            }
        }
    }
}
