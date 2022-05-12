package com.company;

import java.util.Arrays;

public class AssignSignToGetTarget {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 1};
        int target = 3;
//        op   +1-2+3-1=3 and -1+2+3-1=3
//        so, 2 ways
//        s1-s2=D
        int totalSum = 0;
        for (int i : arr)
            totalSum += i;
        int requiredSum = (totalSum + target) / 2;
        int n = arr.length;
        int dp[][] = new int[n][requiredSum + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(CountSubsetWithSum.getCountSubsetWithSum(n - 1, requiredSum, arr, dp));
    }
}
