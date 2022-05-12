package com.company;

import java.util.Arrays;

public class RodCuttingMaxPrice {
    public static void main(String[] args) {
        int[] price = new int[]{2, 5, 7, 8, 10};
//        n-> length of rod
        int n = 5;
//        op->12
//        ie, rod of lengths(1,2,2)=>(2+5+5=12)
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getMaxValue(n - 1, n, price, dp));
//        Tabulation
        for (int[] row : dp)
            Arrays.fill(row, 0);
//        BaseCase
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i * price[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int length = 0; length <= n; length++) {
                int notTaken = 0 + dp[ind - 1][length];
                int taken = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (rodLength <= length)
                    taken = price[ind] + dp[ind][length - rodLength];
                dp[ind][length] = Math.max(notTaken, taken);
            }
        }
        System.out.println(dp[n - 1][n]);

    }

    public static int getMaxValue(int ind, int n, int[] price, int[][] dp) {
        if (ind == 0) {
            return n * price[0];
        }
        if (dp[ind][n] != -1)
            return dp[ind][n];
        int notTake = 0 + getMaxValue(ind - 1, n, price, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if (rodLength <= n)
            take = price[ind] + getMaxValue(ind, n - rodLength, price, dp);
        return dp[ind][n] = Math.max(notTake, take);
    }
}
