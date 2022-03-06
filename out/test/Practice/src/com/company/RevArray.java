package com.company;

public class RevArray {

    public static void rev(int i, int[] list){
        if(i>list.length-1-i){
            return;
        } else{
            int temp=list[i];
            list[i]= list[list.length-1-i];
            list[list.length-1-i]= temp;
            rev(i+1, list);
        }
    }
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        rev(0, arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
