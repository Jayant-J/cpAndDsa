package com.company;

import java.util.Arrays;

public class HouseRobber {
    //    get max but no adjacent and in circular
    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 2};
//        since circular so cant take 0, n-1
//        call SubSeqMaxSumNoAdj from (1 to n-1) and (0 to n-2) and get their max
        int n = arr.length;
        if (n == 0) {
            System.out.println(0);
        }
        if (n == 1) {
            System.out.println(arr[0]);
        }
        SubSeqMaxSumNoAdj.dp = new int[n];
        Arrays.fill(SubSeqMaxSumNoAdj.dp, -1);
        int amt1 = SubSeqMaxSumNoAdj.getMaxSumOfSub(n - 2, Arrays.copyOfRange(arr, 0, n - 1));
        Arrays.fill(SubSeqMaxSumNoAdj.dp, -1);
        int amt2 = SubSeqMaxSumNoAdj.getMaxSumOfSub(n - 2, Arrays.copyOfRange(arr, 1, n));
        System.out.println(Math.max(amt1, amt2));
    }
}
