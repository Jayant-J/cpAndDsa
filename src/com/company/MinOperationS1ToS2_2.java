package com.company;

import java.util.Arrays;

public class MinOperationS1ToS2_2 {
    //    insert, remove, replace
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
//        op-> 3
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getMinOperationS1ToS2_2(n1 - 1, s1, n2 - 1, s2, dp));

//        Tabulation
        dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++)
            dp[i][0] = i;
        for (int i = 0; i <= n2; i++)
            dp[0][i] = i;

        for (int i1 = 1; i1 <= n1; i1++) {
            for (int i2 = 1; i2 <= n2; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                    dp[i1][i2] = 0 + dp[i1 - 1][i2 - 1];
                else {
                    int insert = 1 + dp[i1][i2 - 1];
                    int delete = 1 + dp[i1 - 1][i2];
                    int replace = 1 + dp[i1 - 1][i2 - 1];
                    dp[i1][i2] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        System.out.println(dp[n1][n2]);
    }

    public static int getMinOperationS1ToS2_2(int i1, String s1, int i2, String s2, int[][] dp) {
        if (i1 < 0)
            return i2 + 1;
        if (i2 < 0)
            return i1 + 1;
        if (dp[i1][i2] != -1)
            return dp[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2))
            return dp[i1][i2] = 0 + getMinOperationS1ToS2_2(i1 - 1, s1, i2 - 1, s2, dp);
        else {
            int insert = 1 + getMinOperationS1ToS2_2(i1, s1, i2 - 1, s2, dp);
            int delete = 1 + getMinOperationS1ToS2_2(i1 - 1, s1, i2, s2, dp);
            int replace = 1 + getMinOperationS1ToS2_2(i1 - 1, s1, i2 - 1, s2, dp);
            return dp[i1][i2] = Math.min(insert, Math.min(delete, replace));
        }
    }
}
