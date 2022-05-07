package com.company;

public class StairsProblem {
//   Q. You have been given a number of stairs.
//      Initially, you are at the 0th stair, and you need to reach the Nth stair.
//      Each time you can either climb one step or two steps. You are supposed to
//      return the number of distinct ways in which you can climb from the 0th step to Nth step.
    public static void main(String[] args) {
        //can only jump 1 or 2 to reach
        int n=7;
        int prev2=1;
        int prev1=1;
        for(int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        System.out.println(prev1);
    }
}
