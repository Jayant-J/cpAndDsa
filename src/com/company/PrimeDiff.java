package com.company;

import java.io.*;
import java.util.*;
public class PrimeDiff {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
//        int t=sc.nextInt();
        int t=2;
        while(t>0){
//            String s=sc.nextLine();
            String s="1 10";
            int l=Integer.parseInt(s.split(" ")[0]);
            int r=Integer.parseInt(s.split(" ")[1]);
            System.out.println(l);
            System.out.println(r);
            t--;
        }
    }
}
