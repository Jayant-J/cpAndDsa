package com.company;

import java.util.Arrays;

public class MinPathSumVariableSrcDest {

    public static void main(String[] args) {
        //src any thing in row 1 ie, 1
        //dest any thing in row 4 ie, 8 or 9 or 6 or 10
        int arr[][] = new int[][]{{1}, {2, 3}, {3, 6, 7}, {8, 9, 6, 10}};
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int row = 0; row < dp.length; row++) {
            Arrays.fill(dp[row], -1);
        }
        System.out.println(getMinPathSum(0, 0, n, arr, dp));

//     Tabulation
//        base case
        for (int j = 0; j < n; j++)
            dp[n - 1][j] = arr[n - 1][j];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = arr[i].length-1; j >= 0; j--) {
                int down = arr[i][j] + dp[i + 1][j];
                int diag = arr[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(diag, down);
            }
        }
        System.out.println(dp[0][0]);
    }

    public static int getMinPathSum(int i, int j, int n, int[][] arr, int[][] dp) {
        if (i == n - 1)
            return arr[n - 1][j];
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = arr[i][j] + getMinPathSum(i + 1, j, n, arr, dp);
        int diag = arr[i][j] + getMinPathSum(i + 1, j + 1, n, arr, dp);
        return dp[i][j] = Math.min(down, diag);
    }
}
