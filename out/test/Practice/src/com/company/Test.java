package com.company;

import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        int x=9;
        int y=10;
        int z;
        z=++x+y++;
        System.out.println(z);
        System.out.println(x);
        System.out.println(y);
    }
}
