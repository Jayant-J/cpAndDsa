package com.company;

import java.util.HashMap;
import java.util.Map;

public class RepeatingUsingHash {

    public static void main(String[] args) {
        String str="aaabbaacccdeed";
        HashMap<String,Integer> hm=new HashMap<String, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (hm.containsKey(Character.toString(str.charAt(i)))) {
                String c=Character.toString(str.charAt(i));
                int temp= hm.get(c);
                hm.put(c, temp+1);
            }
            else {
                hm.put(Character.toString(str.charAt(i)), 1);
            }
        }
        for (Map.Entry<String,Integer> c:hm.entrySet()){
            System.out.println(c.getKey());
            System.out.println(c.getValue());
        }
    }
}
