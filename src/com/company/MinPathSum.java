package com.company;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        int arr[][] = new int[][]{{5, 9, 6},
                {11, 5, 2}};
        int n = arr.length, m = arr[0].length;
        //        src=0,0  dest=1,2
        int dp[][] = new int[n][m];
        for (int row = 0; row < dp.length; row++) {
            Arrays.fill(dp[row], -1);
        }
        System.out.println(getMinPathSum(n - 1, m - 1, arr, dp));

//        Tabulation
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0)
                    dp[0][0]=arr[0][0];
                else{
                    int up=arr[i][j];
                    if(i>0)
                        up+=dp[i-1][j];
                    else
                        up=100000;
                    int left=arr[i][j];
                    if(j>0)
                        left+=dp[i][j-1];
                    else
                        left=100000;
                    dp[i][j]=Math.min(up, left);
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }

    public static int getMinPathSum(int i, int j, int[][] arr, int[][] dp) {
        if (i == 0 && j == 0) {
            return arr[0][0];
        }
        if (i < 0 || j < 0) {
            return 1000;//any largest value
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = arr[i][j] + getMinPathSum(i - 1, j, arr, dp);
        int left = arr[i][j] + getMinPathSum(i, j - 1, arr, dp);
        return dp[i][j] = Math.min(up, left);
    }
}
