package com.company;

import java.util.Arrays;

public class StockBuySellNTxn{
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//        op-> 7 ie(buy@1 sell@5 buy@3 sell@6)
        int n = prices.length;
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getMaxProfit(0, prices, 1, dp));

//        Tabulation
        int[][] dP = new int[n + 1][2];
        dP[n][0] = dP[n][1] = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int profit;
                if (canBuy == 1) {
                    //buy or don't
                    int buy = -prices[ind] + dP[ind + 1][0];
                    int notBuy = 0 + dP[ind + 1][1];
                    profit = Math.max(buy, notBuy);
                } else {
                    //sell or don't
                    int sell = prices[ind] + dP[ind + 1][1];
                    int notSell = 0 + dP[ind + 1][0];
                    profit = Math.max(sell, notSell);
                }
                dP[ind][canBuy] = profit;
            }
        }
        System.out.println(dP[0][1]);

//        Tabulation Optimized
        int[] ahead = new int[2];
        int[] current = new int[2];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int profit;
                if (canBuy == 1) {
                    //buy or don't
                    int buy = -prices[ind] + ahead[0];
                    int notBuy = 0 + ahead[1];
                    profit = Math.max(buy, notBuy);
                } else {
                    //sell or don't
                    int sell = prices[ind] + ahead[1];
                    int notSell = 0 + ahead[0];
                    profit = Math.max(sell, notSell);
                }
                current[canBuy] = profit;
            }
            ahead = current;
        }
        System.out.println(ahead[1]);

    }

    public static int getMaxProfit(int ind, int[] prices, int canBuy, int[][] dp) {
        if (ind == prices.length - 1) {
            return 0;
        }
        if (dp[ind][canBuy] != -1)
            return dp[ind][canBuy];
        int profit;
        if (canBuy == 1) {
            //buy or don't
            int buy = -prices[ind] + getMaxProfit(ind + 1, prices, 0, dp);
            int notBuy = 0 + getMaxProfit(ind + 1, prices, 1, dp);
            profit = Math.max(buy, notBuy);
        } else {
            //sell or don't
            int sell = prices[ind] + getMaxProfit(ind + 1, prices, 1, dp);
            int notSell = 0 + getMaxProfit(ind + 1, prices, 0, dp);
            profit = Math.max(sell, notSell);
        }
        return dp[ind][canBuy] = profit;
    }
}