package com.company;

import java.util.Scanner;

public class RomanToInt {
    static int eqInt(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            String roman=sc.nextLine();
            int num=0;
            for(int i=0;i<roman.length();i++){
                if(i+1<roman.length()){
                    if(eqInt(roman.charAt(i))<eqInt(roman.charAt(i+1))) {
                        num += eqInt(roman.charAt(i + 1)) - eqInt(roman.charAt(i));
                        i++;
                    }
                    else
                        num+=eqInt(roman.charAt(i));
                }
                else
                    num+=eqInt(roman.charAt(i));
            }
            System.out.println(num);
        }
    }
}
