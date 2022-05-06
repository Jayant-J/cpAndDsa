package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumNonUniqueEle {

    static int[] arr = {1, 1, 1, 2, 2};
    static int n = 5;

    public static void getSum(int ind, List<Integer> list, int target) {
        if (target == 0) {
            System.out.println(list);
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
                break;
            list.add(arr[i]);
            getSum(i + 1, list, target - arr[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        getSum(0, list, 4);
    }
}

