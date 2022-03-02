package com.company;

import java.util.ArrayList;
import java.util.List;

public class Sum {
    public static void main(String[] args) {
        List<Integer> l=new ArrayList<Integer>();
        l.add(2);
        l.add(3);
        l.add(6);
        l.add(7);
        l.add(11);
        int sum=9;
        int i=0,j=l.size()-1;
        while(i<=j){
            if(l.get(i)+l.get(j)<sum)
                i++;
            else if(l.get(i)+l.get(j)>sum)
                j--;
            else if(l.get(i)+l.get(j)==sum) {
                System.out.println(i + " " + j);
                i++;
                j--;
            }
        }
    }
}
