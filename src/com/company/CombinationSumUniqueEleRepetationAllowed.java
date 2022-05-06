package com.company;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumUniqueEleRepetationAllowed {

    static int[] arr = {2, 3, 6, 7};
    static int n = 4;

    public static void getRes(int ind, List<Integer> list, int target) {
        if (ind == n) {
            if (target == 0) {
                System.out.println(list);
            }
            return;
        }
        if (arr[ind] <= target) {
            list.add(arr[ind]);
            getRes(ind, list, target - arr[ind]);
            list.remove(list.size() - 1);
        }
        getRes(ind + 1, list, target);

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        getRes(0, list, 7);
    }
}

