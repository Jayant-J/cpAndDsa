package com.company;

import java.util.Arrays;

public class UnboundKnapsack {
    //    infinite supply of each item
    public static void main(String[] args) {
        int n = 3;
        int[] wt = {2, 4, 6};
        int[] val = {5, 11, 13};
        int capacity = 10;
//        op-> 27
//        ie, (4,11)(4,11)(2,5)
        int[][] dp = new int[n][capacity + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getMaxValue(n - 1, capacity, wt, val, dp));
//        Tabulation
        for (int[] row : dp)
            Arrays.fill(row, 0);
//        baseCase
        for (int i = 0; i <= capacity; i++) {
            dp[0][i] = ((i / wt[0])) * val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= capacity; cap++) {
                int notTake = 0 + dp[ind - 1][cap];
                int take = Integer.MIN_VALUE;
                if (cap >= wt[ind]) {
                    take = val[ind] + dp[ind][cap - wt[ind]];
                }
                dp[ind][cap] = Math.max(notTake, take);
            }
        }
        System.out.println(dp[n - 1][capacity]);
    }

    public static int getMaxValue(int ind, int capacity, int[] wt, int[] val, int[][] dp) {
        if (ind == 0) {
            return ((capacity / wt[0])) * val[0];
        }
        if (dp[ind][capacity] != -1)
            return dp[ind][capacity];
        int notTake = 0 + getMaxValue(ind - 1, capacity, wt, val, dp);
        int take = Integer.MIN_VALUE;
        if (capacity >= wt[ind]) {
            take = val[ind] + getMaxValue(ind, capacity - wt[ind], wt, val, dp);
        }
        return dp[ind][capacity] = Math.max(notTake, take);
    }
}
