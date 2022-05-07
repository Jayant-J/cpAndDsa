package com.company;

import java.util.Arrays;

public class TotalUniquePaths {
    public static void main(String[] args) {
        int n = 2, m = 2;
        int[][] maze = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getAllWays(0, 0, 1, 1, maze));

//      With tabulation
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                } else {
                    int up = 0, left = 0;
                    if (i > 0)
                        up = dp[i - 1][j];
                    if (j > 0)
                        left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }

    static int[][] dp = new int[2][2];
//    fill dp with -1;

    public static int getAllWays(int srcI, int srcJ, int destI, int destJ, int[][] maze) {
        if (destI == srcI && destJ == srcJ) {
            return 1;
        }
        if (destI < 0 || destJ < 0) {
            return 0;
        }
        if (dp[destI][destJ] != -1) {
            return dp[destI][destJ];
        }
        int up = getAllWays(srcI, srcJ, destI - 1, destJ, maze);
        int left = getAllWays(srcI, srcJ, destI, destJ - 1, maze);
        return dp[destI][destJ] = up + left;
    }
}
