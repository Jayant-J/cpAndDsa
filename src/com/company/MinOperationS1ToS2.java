package com.company;

import java.util.Arrays;

public class MinOperationS1ToS2 {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "anc";
//        op
//        3 ie, remove b, d then add c
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(getMinOperationS1ToS2(n1 - 1, s1, n2 - 1, s2, dp));

    }

    public static int getMinOperationS1ToS2(int i1, String s1, int i2, String s2, int[][] dp) {
        int lscSize = LongestCommonSubSequenceSize.getLongestCommonSubSequence(i1, s1, i2, s2, dp);
        return Math.abs((2 * lscSize) - s1.length() + s2.length());
    }
}
