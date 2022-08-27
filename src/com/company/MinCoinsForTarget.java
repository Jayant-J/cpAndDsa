package com.company;

import java.util.Arrays;

public class MinCoinsForTarget {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        int target = 7;
//        OP-> 3 coins =>{3,3,1}
        int n = coins.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getCount(n - 1, target, coins, dp));

//      Tabulation
        dp = new int[n][target + 1];
//        only 1 coin for all target (0-target)
        for (int i = 0; i <= target; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = 100000;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= target; tar++) {
                int notTake = 0 + dp[ind - 1][tar];
                int take = Integer.MAX_VALUE;
                if (coins[ind] <= tar) {
                    take = 1 + dp[ind][tar - coins[ind]];
                }
                dp[ind][tar] = Math.min(notTake, take);
            }
        }
        System.out.println(dp[n - 1][target]);
    }

    public static int getCount(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (target % arr[0] == 0) {
                return target / arr[0];
            } else
                return 100000;
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];
        int notTake = 0 + getCount(ind - 1, target, arr, dp);
        int take = Integer.MAX_VALUE;
        if (arr[ind] <= target) {
            take = 1 + getCount(ind, target - arr[ind], arr, dp);
        }
        return dp[ind][target] = Math.min(notTake, take);
    }
}
