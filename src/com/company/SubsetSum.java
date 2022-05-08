package com.company;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 1, 1};
        int target = 4;
        int[][] dp = new int[arr.length][target + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        System.out.println(getSubsetWithSum(arr.length - 1, target, arr, dp));

//        Tabulation
        int n = arr.length;
        boolean[][] dP = new boolean[n][target + 1];
//            base case
        for (int i = 0; i < n - 1; i++) {
            dP[i][0] = true;
        }
        dP[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = dP[i - 1][j];
                boolean take = false;
                if (j >= arr[i])
                    take = dP[i - 1][j - arr[i]];
                dP[i][j] = notTake || take;
            }
        }
        System.out.println(dP[n - 1][target]);
    }

    public static boolean getSubsetWithSum(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return true;
        if (ind == 0)
            return arr[0] == target;
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;
        boolean notTake = getSubsetWithSum(ind - 1, target, arr, dp);
        boolean take = false;
        if (target >= arr[ind])
            take = getSubsetWithSum(ind - 1, target - arr[ind], arr, dp);
        dp[ind][target] = notTake || take ? 1 : 0;
        return take || notTake;
    }
}
