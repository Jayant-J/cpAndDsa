package com.company;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static boolean isPalin(String s, int i, int j){
        while (i<=j){
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }
    public static void partition(String str, int ind, List<String> list){
        if(ind==str.length()) {
            System.out.println(list);
            return;
        }
        for(int i=ind; i<str.length();i++){
            if(isPalin(str, ind, i)){
                list.add(str.substring(ind, i+1));
                partition(str, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        String str="aabb";
        List<String> list=new ArrayList<>();
        partition(str, 0, list);
    }
}
