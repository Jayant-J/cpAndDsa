package com.company;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = 8;
        for (int i = 0; i < 3; i++) {
            int temp=arr[0];
            for(int j=0;j<8-1;j++){
                arr[j]=arr[j+1];
            }
            arr[8-1]=temp;
        }
        for(int i=0;i<8;i++){
            System.out.println(arr[i]);
        }
    }
}
