package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Eg {
    public static void main(String[] args) {
        List<String> l =new ArrayList<>();
        l.add("a");
        l.add("1");
        Collections.sort(l);
        System.out.println(l);
        System.out.println("apple".compareTo("banana"));
    }
}
