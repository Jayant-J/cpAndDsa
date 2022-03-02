package com.company;

import java.util.Arrays;

public class UnsortedSubArray {
    public static int findUnsortedSubarray(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] pre = new int[j + 1];
        for (i = 0; i <= j; i++)
            pre[i] = nums[i];
        i = 0;
        Arrays.sort(nums);
        boolean same = true;
        while (same) {
            if (pre[i] == nums[i] && i < j)
                i++;
            else
                break;
        }
        while (same) {
            if (pre[j] == nums[j] && j > i)
                j--;
            else
                break;
        }
        if (j - i == 0)
            return 0;
        else
            return j - i + 1;
    }

//    public static void main(String[] args) {
//        System.out.println(findUnsortedSubarray([1,2,3,7,4,5,8]);
//    }
}
