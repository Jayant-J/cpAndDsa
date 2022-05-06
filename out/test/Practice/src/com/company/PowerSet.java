package com.company;

public class PowerSet {

    public static void main(String[] args) {
        String s="abc";

        for(int i=0;i<Math.pow(2, s.length());i++){
            String sub="";
            for(int j=0;j<s.length();j++){
                if((i & (1<<j))>0){
                    sub+=s.charAt(j);
                }
            }
            System.out.print(sub + " : ");
        }
    }
}

