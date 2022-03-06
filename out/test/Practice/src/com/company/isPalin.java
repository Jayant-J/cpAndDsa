package com.company;

public class isPalin {

    public static boolean isPalin(String str, int i){
        if(i>=(str.length()-1)/2)
            return true;
        if(str.charAt(i)!=str.charAt(str.length()-1-i))
            return false;
        return isPalin(str, i+1);
    }

    public static void main(String[] args) {
        System.out.println(isPalin("abddef", 0));
        System.out.println(isPalin("madam", 0));
    }
}
