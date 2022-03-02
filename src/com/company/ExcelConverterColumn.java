package com.company;

import java.util.Scanner;

public class ExcelConverterColumn {
    static int corNum(char c){
        return c-'A';
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true) {
//            String c = sc.nextLine();
//            int num = 0;
//            for (int i = 0; i<c.length(); i++) {
//
//                num = 26*num+corNum(c.charAt(i))+1;
//            }
//            System.out.println(num);
            String res="";
            int no=sc.nextInt();
            int t=no;
            while(t>0){
                int rem=t%26;
                if(rem==0) {
                    res = "Z" + res;
                    t = (t / 26) - 1;
                }
                else {
                    res = (char) (rem - 1 + 'A') + res;
                    t = t / 26;
                }
            }
            System.out.println(res);
        }
    }
}
