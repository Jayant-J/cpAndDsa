package com.company;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        int n = 3;
        int wt[] = {3, 4, 5};
        int val[] = {30, 50, 60};
        int capacity = 8;
        int dp[][] = new int[n][capacity + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getMaxValue(n - 1, capacity, wt, val, dp));

//        Tabulation
        for (int[] row : dp)
            Arrays.fill(row, 0);
        for (int i = wt[0]; i <= capacity; i++) {
            dp[0][i] = val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= capacity; cap++) {
                int notTake = 0 + dp[ind - 1][cap];
                int take = Integer.MIN_VALUE;
                if (cap >= wt[ind]) {
                    take = val[ind] + dp[ind - 1][cap - wt[ind]];
                }
                dp[ind][cap] = Math.max(notTake, take);
            }
        }
        System.out.println(dp[n - 1][capacity]);
    }

    public static int getMaxValue(int ind, int capacity, int[] wt, int val[], int[][] dp) {
        if (ind == 0) {
            if (capacity >= wt[0])
                return val[ind];
            else
                return 0;
        }
        if (dp[ind][capacity] != -1)
            return dp[ind][capacity];
        int notTake = 0 + getMaxValue(ind - 1, capacity, wt, val, dp);
        int take = Integer.MIN_VALUE;
        if (capacity >= wt[ind]) {
            take = val[ind] + getMaxValue(ind - 1, capacity - wt[ind], wt, val, dp);
        }
        return dp[ind][capacity] = Math.max(notTake, take);
    }
}
