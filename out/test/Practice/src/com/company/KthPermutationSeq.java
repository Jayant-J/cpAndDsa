package com.company;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSeq {

    static int k=17;
    static String str="abcd";

    public static String getKthPermutation(String s, int kth) {
        int fact=1;
        List<Integer> nums=new ArrayList<>();
        for(int i=1;i<str.length();i++){
            fact*=i;
            nums.add(i);
        }
        nums.add(str.length());
        k=k-1;
        String ans="";
        while(true){
            ans=ans+nums.get(k/fact);
            nums.remove(k/fact);
            if(nums.size()==0)
                break;
            k=k%fact;
            fact=fact/nums.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        String indexes=getKthPermutation(str, k);
        for(int i=0;i<indexes.length();i++){
            System.out.print(str.charAt(indexes.charAt(i)-'0'-1));
        }
    }
}
