package com.company;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

//    0 1 1 2 3 5 8 13 ....
    public static int nthNumber(int N){
        if(N==0)
            return 0;
        if(N==1)
            return 1;
        return nthNumber(N-1)+nthNumber(N-2);
    }

    public static void main(String[] args) {
        System.out.println(nthNumber(7));
    }
}
