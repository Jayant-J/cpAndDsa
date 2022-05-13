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
//    To print the String
        String s2 = String.valueOf(new StringBuffer(s).reverse());
        int n2 = n;
//        same logic as longest common subsequence (n-1, s, n2-1, s2)
        String[][] dP = new String[n + 1][n2 + 1];
//        Tabulation
        for (int i = 0; i <= n; i++)
            dP[i][0] = "";
        for (int i = 0; i <= n2; i++)
            dP[0][i] = "";
        for (int i1 = 1; i1 <= n; i1++) {
            for (int i2 = 1; i2 <= n2; i2++) {
                if (s.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    dP[i1][i2] = s.charAt(i1 - 1) + dP[i1 - 1][i2 - 1];
                } else {
                    if (dP[i1 - 1][i2].length() > dP[i1][i2 - 1].length())
                        dP[i1][i2] = "" + dP[i1 - 1][i2];
                    else
                        dP[i1][i2] = "" + dP[i1][i2 - 1];
                }
            }
        }
        System.out.println(dP[n][n2]);
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
