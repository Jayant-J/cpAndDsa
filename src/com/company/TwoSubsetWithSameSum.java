package com.company;

import java.util.Arrays;

public class TwoSubsetWithSameSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 4, 5};
        int n = arr.length;
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        if (totalSum % 2 != 0)
            System.out.println(false);
        else {
            int target = totalSum / 2;
            int[][] dp = new int[arr.length][target + 1];
            for (int row[] : dp)
                Arrays.fill(row, -1);
            System.out.println(SubsetSum.getSubsetWithSum(n - 1, target, arr, dp));
        }
    }
}
