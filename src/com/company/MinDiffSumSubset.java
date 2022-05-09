package com.company;
//Partition a set into two subsets such that the difference of subset sums is minimum.
public class MinDiffSumSubset {
    public static void main(String[] args) {
        int arr[]=new int[]{1,3,2,8,1};
//        (sum of all ele)/2
        int totalSum=15;
        int target=totalSum/2;
//      use subset sum tabulation code;
        int n = arr.length;
        boolean[][] dP = new boolean[n][target + 1];
//            base case
        for (int i = 0; i < n - 1; i++) {
            dP[i][0] = true;
        }
        dP[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = dP[i - 1][j];
                boolean take = false;
                if (j >= arr[i])
                    take = dP[i - 1][j - arr[i]];
                dP[i][j] = notTake || take;
            }
        }
//        last row of dp shows which sum are possible; sp[n-1][cols]
        int min=100000;
        for(int s1=0;s1<=target;s1++){
              if(dP[n-1][s1]==true){
                  min=Math.min(min, Math.abs((totalSum - s1) - s1));
              }
        }
        System.out.println(min);
    }
}
