package com.company;

public class RearrangeNoConsecutive {
    static char getMaxCountChar(int[] count) {
        int max = 0;
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ch = (char) ((int) 'a' + i);
            }
        }
        return ch;
    }

    static String rearrangeString(String S) {
        int n = S.length();
        if (n == 0)
            return "";
        int[] count = new int[26];
        for (char ch : S.toCharArray()) {
            count[(int) ch - (int) 'a']++;
        }
        char ch_max = getMaxCountChar(count);
        int maxCount = count[(int) ch_max - (int) 'a'];
        if (maxCount > (n + 1) / 2)
            return "";
        String res = "";
        for (int i = 0; i < n; i++) {
            res += ' ';
        }
        int ind = 0;
        while (maxCount > 0) {
            res = res.substring(0, ind) + ch_max + res.substring(ind + 1);
            ind = ind + 2;
            maxCount--;
        }
        count[(int) ch_max - (int) 'a'] = 0;
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                ind = (ind >= n) ? 1 : ind;
                res = res.substring(0, ind) + (char) ((int) 'a' + i) + res.substring(ind + 1);
                ind += 2;
                count[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "aaabbbbcccc";
        String res = rearrangeString(str);
        if (res == "")
            System.out.println("Not valid string");
        else
            System.out.println(res);
    }
}

