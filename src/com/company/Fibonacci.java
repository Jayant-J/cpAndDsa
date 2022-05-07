package com.company;

public class Fibonacci {

    public static void main(String[] args) {
        int n=7;
        int dp[]=new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        getFib(n, dp);
        System.out.println(dp[n]);
//      Using Tabularization
        dp[0]=0;dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
//            OR
        int prev2=0, prev1=1, curr=1;
            curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        System.out.println(curr);
    }
    public static int getFib(int n, int[] dp){
        if(n<=1)
            return n;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=getFib(n-1, dp)+getFib(n-2, dp);
    }
}

