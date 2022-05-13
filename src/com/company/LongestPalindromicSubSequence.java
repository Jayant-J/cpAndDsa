package com.company;

import java.util.Arrays;

public class LongestPalindromicSubSequence {
    public static void main(String[] args) {
        String s = "bbabcbcab";
        int n = s.length();
//        op-> 7 ie, babcbab
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getLongestPalindromicSubSequence(n - 1, 0, s, dp));
    }

    private static int getLongestPalindromicSubSequence(int i1, int i2, String s, int[][] dp) {
        if (i1 < i2) {
            return 0;
        }
        if (i1 == i2) {
            return 1;
        }
        if (dp[i1][i2] != -1)
            return dp[i1][i2];
        if (s.charAt(i1) == s.charAt(i2)) {
            return dp[i1][i2] = 2 + getLongestPalindromicSubSequence(i1 - 1, i2 + 1, s, dp);
        } else {
            return dp[i1][i2] = 0 + Math.max(getLongestPalindromicSubSequence(i1, i2 + 1, s, dp),
                    getLongestPalindromicSubSequence(i1 - 1, i2, s, dp));
        }
    }
}
