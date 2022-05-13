package com.company;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String s1 = "adcbc";
        String s2 = "dcadb";
        int n1 = s1.length();
        int n2 = s2.length();
//        op-> acb
        String[][] dp = new String[n1 + 1][n2 + 1];
//        Tabulation
        for (int i = 0; i <= n1; i++)
            dp[i][0] = "";
        for (int i = 0; i <= n2; i++)
            dp[0][i] = "";
        for (int i1 = 1; i1 <= n1; i1++) {
            for (int i2 = 1; i2 <= n2; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    dp[i1][i2] = s1.charAt(i1 - 1) + dp[i1 - 1][i2 - 1];
                } else {
                    if (dp[i1 - 1][i2].length() > dp[i1][i2 - 1].length())
                        dp[i1][i2] = "" + dp[i1 - 1][i2];
                    else
                        dp[i1][i2] = "" + dp[i1][i2 - 1];
                }
            }
        }
        System.out.println(dp[n1][n2]);
    }
}
