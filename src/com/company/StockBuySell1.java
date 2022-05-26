package com.company;

public class StockBuySell1 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(getMaxProfit(prices));
    }

    public static int getMaxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice=-1;
        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice, prices[i]);
            maxProfit=Math.max(maxProfit, prices[i]-minPrice);
        }
        return maxProfit;
    }
}

