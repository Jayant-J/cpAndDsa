package com.company;

public class ThreeD_DP {

    public static void main(String[] args) {
        int arr[][] = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};
        int n = arr.length;
        int m = arr[0].length;
        int dp[][][] = new int[n][m][m];
        System.out.println(getMaxPathSum(0, 0, m - 1, arr, dp));

        //Tabulation
        // base case
        int[][] front = new int[m][m];
        int curr[][] = new int[m][m];
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = arr[n - 1][j1];
                else
                    front[j1][j2] = arr[n - 1][j1] + arr[n - 1][j2];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;
                    //Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;
                            if (j1 == j2)
                                ans = arr[i][j1];
                            else
                                ans = arr[i][j1] + arr[i][j2];
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += -100000;
                            else
                                ans += front[j1 + di][j2 + dj];

                            maxi = Math.max(ans, maxi);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            for (int a = 0; a < m; a++) {
                front[a] = (int[])(curr[a].clone());
            }
        }
        System.out.println(front[0][m-1]);
    }

    public static int getMaxPathSum(int i, int j1, int j2, int arr[][], int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= arr[0].length || j2 >= arr[0].length)
            return -100000;
        if (dp[i][j1][j2] != 0) {
            return dp[i][j1][j2];
        }
        if (i == arr.length - 1) {//(n-1)
            if (j1 == j2)
                return arr[i][j1];
            else
                return arr[i][j1] + arr[i][j2];
        }
        int max = -100000;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value;
                if (j1 == j2)
                    value = arr[i][j1];
                else
                    value = arr[i][j1] + arr[i][j2];
                value += getMaxPathSum(i + 1, j1 + dj1, j2 + dj2, arr, dp);
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][arr[0].length - 1] = max;
    }
}
