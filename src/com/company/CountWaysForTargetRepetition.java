package com.company;

import java.util.Arrays;

public class CountWaysForTargetRepetition {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int target = 3;
//        op 4 ways
//        ie, {1,1,1,1}{1,1,2}{1,3}{2,2}
        int n = arr.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getCountWaysForTargetRepetition(n - 1, target, arr, dp));

//        Tabulation
        for (int[] row : dp)
            Arrays.fill(row, 0);
//        BaseCase
        for (int i = 0; i <= target; i++) {
            dp[0][i] = (i % arr[0]) == 0 ? 1 : 0;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= target; tar++) {
                int notTake = dp[ind - 1][tar];
                int take = 0;
                if (arr[ind] <= tar)
                    take = dp[ind][tar - arr[ind]];
                dp[ind][tar] = take + notTake;
            }
        }
        System.out.println(dp[n - 1][target]);
    }

    //TC->O(NT),SC->O(NT)
    public static int getCountWaysForTargetRepetition(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (target % arr[0] == 0)
                return 1;
            else
                return 0;
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];
        int notTake = getCountWaysForTargetRepetition(ind - 1, target, arr, dp);
        int take = 0;
        if (arr[ind] <= target)
            take = getCountWaysForTargetRepetition(ind, target - arr[ind], arr, dp);
        return dp[ind][target] = take + notTake;
    }
}
