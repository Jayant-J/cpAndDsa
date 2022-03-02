package com.company;

public class Palin {
    public static void main(String[] args) {
        System.out.println(Character.compare('a', 'a'));
        String s1 = "abadbba";
        int i = 0, j = 0;
        if (s1.length() % 2 == 0) {
            j = s1.length() / 2;
            i = j - 1;
        } else {
            j = (s1.length() / 2) + 1;
            i = (s1.length() / 2) - 1;
        }
        while (i >= 0 && j < s1.length()) {
            System.out.println("i : " + i + " " + s1.charAt(i));
            System.out.println("j : " + j + " " + s1.charAt(j));
            if (Character.compare(s1.charAt(i), s1.charAt(j)) == 0) {
                System.out.println(Character.compare(s1.charAt(i), s1.charAt(j)));
                i--;
                j++;
            } else
                break;
        }
        System.out.println(s1.length());
        System.out.println(j);
        System.out.println(i);
        if (i == -1 && j == s1.length()) {
            System.out.println("P");
        } else
            System.out.println("NP");
    }
}
