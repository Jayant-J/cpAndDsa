package com.company;

import java.util.Arrays;

public class FrogJump {
//    energy to go from i to j->Height(j-i) he can jump 1 or 2
//    find minimum energy to go

    public static void main(String[] args) {
        int n = 8;
        int energy[] = new int[]{7, 4, 4, 2, 6, 6, 3, 4};
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(getMinEnergyWithDP(n - 1, energy, dp));
    }

    public static int getMinEnergyWithDP(int ind, int energy[], int dp[]) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1) {
            return dp[ind];
        }
        int left = getMinEnergyWithDP(ind - 1, energy, dp) + Math.abs(energy[ind] - energy[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1) {
            right = getMinEnergyWithDP(ind - 1, energy, dp) + Math.abs(energy[ind] - energy[ind - 2]);
        }
        return dp[ind] = Math.min(left, right);
    }
}
