package com.company;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
    static boolean isAnagram(String s, String t) {
        List<Character> l1=new ArrayList<Character>();
        List<Character> l2=new ArrayList<Character>();
        if(s.length()!=t.length())
            return false;
        for (int i=0;i<s.length();i++){
            l2.add(t.charAt(i));
            l1.add(s.charAt(i));
        }
        l1.removeAll(l2);
        if(l1.size()==0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aacc","ccac"));
    }
}
