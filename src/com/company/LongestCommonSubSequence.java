package com.company;

import java.util.Arrays;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String s1 = "adcbc";
        String s2 = "dcadb";
        int n1 = s1.length();
        int n2 = s2.length();
//        op-> dcb
        int[][] dp = new int[n1][n2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getLongestCommonSubSequence(n1 - 1, s1, n2 - 1, s2, dp));

//        Tabulation
        int[][] dP = new int[n1 + 1][n2 + 1];
//        baseCase
        for (int i = 0; i <= n1; i++)
            dP[i][0] = 0;
        for (int i = 0; i <= n2; i++)
            dP[0][i] = 0;
        for (int i1 = 1; i1 <= n1; i1++) {
            for (int i2 = 1; i2 <= n2; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    dP[i1][i2] = 1 + dP[i1 - 1][i2 - 1];
                } else {
                    dP[i1][i2] = 0 + Math.max(dP[i1 - 1][i2],
                            dP[i1][i2 - 1]);
                }
            }
        }
        System.out.println(dP[n1][n2]);
    }

    private static int getLongestCommonSubSequence(int i1, String s1, int i2, String s2, int[][] dp) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }
        if (dp[i1][i2] != -1)
            return dp[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return dp[i1][i2] = 1 + getLongestCommonSubSequence(i1 - 1, s1, i2 - 1, s2, dp);
        } else {
            return dp[i1][i2] = 0 + Math.max(getLongestCommonSubSequence(i1 - 1, s1, i2, s2, dp),
                    getLongestCommonSubSequence(i1, s1, i2 - 1, s2, dp));
        }
    }
}
