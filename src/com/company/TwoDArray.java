package com.company;
public class TwoDArray {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(i + "" + j + " ");
            System.out.println();
        }
//        System.out.println("================================");
//        for (int i = arr.length - 1; i >= 0; i--) {
//            for (int j = 0; j < arr[0].length; j++)
//                System.out.print(j + "" + i + " ");
//            System.out.println();
//        }
//        System.out.println("================================");
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++)
//                System.out.print(j + "" + i + " ");
//            System.out.println();
//        }
        System.out.println("================================");
        for (int i = 0; i <arr.length ; i++) {
            for (int j = arr[0].length-1; j >=0; j--)
                System.out.print(j + "" + i + " ");
            System.out.println();
        }
    }
}
