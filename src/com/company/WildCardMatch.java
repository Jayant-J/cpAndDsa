package com.company;

import java.util.Arrays;

public class WildCardMatch {
    //    ?-> 1 character; *-> seq of character
    public static void main(String[] args) {
        String s1 = "?ay*";
        String s2 = "jayant";
//        o/p-> true
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(isWildCardMatch(n1 - 1, s1, n2 - 1, s2, dp));
//        Tabulation
        dp = new int[n1 + 1][n2 + 1];

    }

    public static boolean isWildCardMatch(int i1, String s1, int i2, String s2, int[][] dp) {
        if (i1 < 0 && i2 < 0)
            return true;
        if (i1 < 0 && !(i2 < 0))
            return false;
        if (i2 < 0 && !(i1 < 0))
            return false;
        if (s1.charAt(i1) == '?' || (s1.charAt(i1) == s2.charAt(i1)))
            return isWildCardMatch(i1 - 1, s1, i2 - 1, s2, dp);
        else if (s1.charAt(i1) == '*') {
            return isWildCardMatch(i1 - 1, s1, i2, s2, dp) || isWildCardMatch(i1, s1, i2 - 1, s2, dp);
        } else
            return false;
    }
}
