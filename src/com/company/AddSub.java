package com.company;

public class AddSub {
        static int getSum(int a, int b) {
            int c = a, d = b;
            while (b != 0) {
                int carry = a & b;
                a = a ^ b;
                b = carry << 1;
            }
            return (a);
        }
        static int getDiff(int c,int d){
            while(c!=0){
                int borrow=((~c)&d);
                c=c^d;
                d= borrow<<1;
            }
            return (c);
        }

    public static void main(String[] args) {
        System.out.println(getSum(3,4));
        System.out.println(getDiff(4,3));
    }
}
