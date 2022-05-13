package com.company;

import java.util.Arrays;

public class DistinctOccurrenceOfSubSeq {
    public static void main(String[] args) {
        String s1 = "baggbag";
        String s2 = "bag";
//        op -> 5 occurrence
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getOccurrenceOfSubSeq(n1 - 1, s1, n2 - 1, s2, dp));
//      Tabulation
        dp = new int[n1 + 1][n2 + 1];
//        basecase
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = 0;
        }
        for (int i1 = 1; i1 <= n1; i1++) {
            for (int i2 = 1; i2 <= n2; i2++) {
                if (s1.charAt(i1 - 1) == s1.charAt(i2 - 1))
                    dp[i1][i2] = dp[i1 - 1][i2 - 1] + dp[i1 - 1][i2];
                else
                    dp[i1][i2] = dp[i1 - 1][i2];
            }
        }
        System.out.println(dp[n1][n2]);
    }

    public static int getOccurrenceOfSubSeq(int i1, String s1, int i2, String s2, int[][] dp) {
        if (i2 < 0)
            return 1;
        if (i1 < 0)
            return 0;
        if (dp[i1][i2] != -1)
            return dp[i1][i2];
        if (s1.charAt(i1) == s1.charAt(i2))
            return dp[i1][i2] = getOccurrenceOfSubSeq(i1 - 1, s1, i2 - 1, s2, dp)
                    + getOccurrenceOfSubSeq(i1 - 1, s1, i2, s2, dp);
        return dp[i1][i2] = getOccurrenceOfSubSeq(i1 - 1, s1, i2, s2, dp);
    }
}
