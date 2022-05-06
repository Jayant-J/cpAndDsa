package com.company;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumUniqueEleRepetationNotAllowed {

    static int n = 4;
    static int[] arr = new int[]{2, 3, 6, 7};

    public static void getCombinationSum(int i, List<Integer> l, int sum, int req) {
        if (i >= n) {
            if (sum == req) {
                System.out.println(l);
            }
            return;
        }
        l.add(arr[i]);
        sum += arr[i];
        getCombinationSum(i + 1, l, sum, req);
        l.remove(l.size() - 1);
        sum -= arr[i];
        getCombinationSum(i + 1, l, sum, req);
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        getCombinationSum(0, l, 0, 7);
    }
}

