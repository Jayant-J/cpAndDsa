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
        Arrays.fill(dp, -1);
        int dpNew[]=new int[n];
        getMinEnergyWithDPTabulation(n, energy, dpNew);
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
            right = getMinEnergyWithDP(ind - 2, energy, dp) + Math.abs(energy[ind] - energy[ind - 2]);
        }
        return dp[ind] = Math.min(left, right);
    }

    public static void getMinEnergyWithDPTabulation(int n, int energy[], int dp[]) {
//        dp[0] = 0;
        int prev1=0, prev2=0;
        int first, second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
//            first = dp[i - 1] + Math.abs(energy[i] - energy[i - 1]);
            first = prev1 + Math.abs(energy[i] - energy[i - 1]);
            if (i > 1) {
//                second = dp[i - 2] + Math.abs(energy[i] - energy[i - 2]);
                second = prev2 + Math.abs(energy[i] - energy[i - 2]);
            }
//            dp[i] = Math.min(first, second);
            int curr = Math.min(first, second);
            prev2=prev1;
            prev1=curr;
        }
        System.out.println(prev1);
//        System.out.println(dp[n-1]);
    }
}
