package com.company;

public class FrogJumpKIndex {
    public static void main(String[] args) {
        int n = 8;
        int energy[] = new int[]{7, 4, 4, 2, 6, 6, 3, 4};
        int k = 5;
        int dp[] = new int[n];
        System.out.println(getMinEnergy(n, k, energy, dp));
    }

    public static int getMinEnergy(int n, int k, int[] energy, int[] dp) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(energy[i] - energy[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1];
    }
}
