package com.company;

import java.util.Arrays;

public class SubsetWithDifferenceD {
    //    s1>s2 and s1-s2=D
    public static void main(String[] args) {
        int arr[] = new int[]{5, 2, 6, 4};
        int n = arr.length;
        int d = 3;
        int totalSum = 17;
        int target = (totalSum + d) / 2;
        int dp[][] = new int[n][target + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(CountSubsetWithSum.getCountSubsetWithSum(n - 1, target, arr, dp));
    }
}
