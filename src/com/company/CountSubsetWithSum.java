package com.company;

import java.util.Arrays;

public class CountSubsetWithSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int n = arr.length;
        int target = 3;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getCountSubsetWithSum(n - 1, target, arr, dp));

//        Tabulation
        for (int[] row : dp)
            Arrays.fill(row, 0);
//        base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= target)
            dp[0][arr[0]] = 1;
        for (int ind = 1; ind < n; ind++) {
            for (int sum = 0; sum <= target; sum++) {
                int notTake = dp[ind - 1][sum];
                int take = 0;
                if (arr[ind] <= sum) {
                    take = dp[ind - 1][sum - arr[ind]];
                }
                dp[ind][sum] = (take + notTake);
            }
        }
        System.out.println(dp[n - 1][target]);
    }

    public static int getCountSubsetWithSum(int ind, int target, int[] arr, int[][] dp) {
//        if (target == 0) {
//            return 1;
//        }
        if (ind == 0) {
            if(target==0 && arr[ind]==2)
                return 2;
            if(target==0 || target ==arr[0])
                return 1;
            else
                return 0;
//            return arr[ind] == target ? 1 : 0;
        }
        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }
        int notTake = getCountSubsetWithSum(ind - 1, target, arr, dp);
        int take = 0;
        if (arr[ind] <= target) {
            take = getCountSubsetWithSum(ind - 1, target - arr[ind], arr, dp);
        }
        return dp[ind][target] = (take + notTake);
    }
}
