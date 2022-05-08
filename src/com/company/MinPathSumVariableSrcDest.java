package com.company;

import java.util.Arrays;

public class MinPathSumVariableSrcDest {

    public static void main(String[] args) {
        int arr[][] = new int[][]{{1, 2, 10, 4}, {100, 3, 2, 1}, {1, 2, 20, 2}, {1, 2, 2, 1}};
        int n = arr.length;
        int dp[][] = new int[n][n];
        initializeDP(dp);
        //call for all ele of last row
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < arr[0].length; j++) {
            min = Math.min(min, getMinPathSum(arr.length - 1, j, arr, dp));
            initializeDP(dp);
        }
        System.out.println(min);
//     Tabulation
        //base case
        for (int j = 0; j < arr[0].length; j++) {
            dp[0][j] = arr[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int up = arr[i][j] + dp[i - 1][j];
                int leftDiagonal = arr[i][j];
                if (j - 1 >= 0)
                    leftDiagonal += dp[i - 1][j - 1];
                else
                    leftDiagonal += 1000000;

                int rightDiagonal = arr[i][j];
                if (j + 1 < arr[0].length)
                    rightDiagonal += dp[i - 1][j + 1];
                else
                    rightDiagonal += 1000000;

                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));

            }
        }

        int mini = Integer.MAX_VALUE;

        for (int j = 0; j < arr[0].length; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }
        System.out.println(mini);
    }

    public static int getMinPathSum(int i, int j, int[][] arr, int dp[][]) {
        if (j < 0 || j >= arr[0].length)
            return 100000;
        if (i == 0) {
            return arr[0][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = arr[i][j] + getMinPathSum(i - 1, j, arr, dp);
        int leftDiag = arr[i][j] + getMinPathSum(i - 1, j - 1, arr, dp);
        int rightDiag = arr[i][j] + getMinPathSum(i - 1, j + 1, arr, dp);
        return dp[i][j] = Math.min(up, Math.min(leftDiag, rightDiag));
    }

    static void initializeDP(int dp[][]) {
        for (int row = 0; row < dp.length; row++) {
            Arrays.fill(dp[row], -1);
        }
    }
}
