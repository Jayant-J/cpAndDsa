package com.company;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
//        op -> bgruoote
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n2; i++) {
            dp[0][i] = 0;
        }
//        getting length
        for (int ind1 = 1; ind1 <= n1; ind1++) {
            for (int ind2 = 1; ind2 <= n2; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }
        System.out.println(dp[n1][n2]);
//        to print the string
        String ans = "";
        int len = dp[n1][n2];
        int i = n1;
        int j = n2;
        int index = len - 1;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans += s1.charAt(i - 1);
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans += s1.charAt(i - 1);
                i--;
            } else {
                ans += s2.charAt(j - 1);
                j--;
            }
        }
        while (i > 0) {
            ans += s1.charAt(i - 1);
            i--;
        }
        while (j > 0) {
            ans += s2.charAt(j - 1);
            j--;
        }
        String ans2 = new StringBuilder(ans).reverse().toString();
        System.out.println(ans2);
    }
}
