package com.company;

import java.util.Arrays;

public class SubSeqMaxSumNoAdj {
    static int[] dp;

    public static void main(String[] args) {
        int arr[] = new int[]{2, 1, 4, 9};
//        Ans = 11
        int n = arr.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(getAllSub(n - 1, arr));

//        TABULATION

        dp[0] = arr[0];
        int neg = 0;
        for (int i = 1; i < n; i++) {
            int take = arr[i];
            if (i > 1)
                take += dp[i - 2];
            int notTake = 0 + dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        System.out.println(dp[n-1]);
    }

    public static int getAllSub(int ind, int arr[]) {
        if (ind == 0) {
            return arr[ind];
        }
        if (ind < 0) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }
        int pick = arr[ind] + getAllSub(ind - 2, arr);
        int notPick = 0 + getAllSub(ind - 1, arr);
        return dp[ind] = Math.max(pick, notPick);
    }
}
