package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int cases=0;cases<t;cases++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int count=0;
            while(a!=b){
                if(a>b){
                    count+=a-b;
                    b+=(a-b);
                } else if((b-a)!=1 && (a|(b-a))<=b){
                    a=a|(b-a);
                    count+=1;
                } else{
                    a+=1;
                    count+=1;
                }
            }
            System.out.println(count);
        }
    }
    public static int getGCD(int a, int b){
        if (b == 0)
            return a;
        return getGCD(b, a % b);
    }
}