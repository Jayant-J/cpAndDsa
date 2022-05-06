package com.company;

import java.util.Arrays;

public class SubSequenceContinuous {

    static void printSubArrays(int[] arr, int start, int end) {
        if (end == arr.length)
            return;
        else if (start > end)
            printSubArrays(arr, 0, end + 1);
        else {
            printElements(Arrays.copyOfRange(arr, start, end + 1));
            printSubArrays(arr, start + 1, end);
        }
        return;
    }

    public static void printElements(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 3};
        printSubArrays(arr, 0, 0);
    }
}
