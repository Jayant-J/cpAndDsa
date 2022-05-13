package com.company;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "adcjklp";
        String s2 = "acjklp";
        int n1 = s1.length();
        int n2 = s2.length();
//        op-> 5 ie -> cjklp
        int[][] dp = new int[n1 + 1][n2 + 1];
//        Tabulation
//        baseCase
        for (int i = 0; i <= n1; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= n2; i++)
            dp[0][i] = 0;
        int max = 0;

        for (int i1 = 1; i1 <= n1; i1++) {
            for (int i2 = 1; i2 <= n2; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                else
                    dp[i1][i2] = 0;
                if (max < dp[i1][i2])
                    max = dp[i1][i2];
            }
        }
        System.out.println(max);
    }
}
