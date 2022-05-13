package com.company;

import java.util.Arrays;

public class MinInsertionMakePalin {
    public static void main(String[] args) {
        String s = "abcaa";
        int n = s.length();
//        op->2  -> a'a'bc'b'aa
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getMinInsertionMakePalin(n - 1, 0, s, dp));
    }

    private static int getMinInsertionMakePalin(int i1, int i2, String s, int[][] dp) {
        if (i1 < i2)
            return 0;
        if (s.charAt(i1) == s.charAt(i2))
            return 0 + getMinInsertionMakePalin(i1 - 1, i2 + 1, s, dp);
        if (dp[i1][i2] != -1)
            return dp[i1][i2];
        else
            return dp[i1][i2] = 1 + Math.min(getMinInsertionMakePalin(i1 - 1, i2, s, dp),
                    getMinInsertionMakePalin(i1, i2 + 1, s, dp));
    }
}
