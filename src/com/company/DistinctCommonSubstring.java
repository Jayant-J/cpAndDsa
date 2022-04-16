package com.company;

public class DistinctCommonSubstring {
    Node root;

    DistinctCommonSubstring() {
        root = new Node();
    }

    public void countDistinctCommonSubstring(String word) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            Node node = root;
            for (int j = i; j < word.length(); j++) {
                if (!(node.containsKey(word.charAt(j)))) {
                    cnt++;
                    node.put(word.charAt(j), new Node());
                }
                node = node.get(word.charAt(j));
            }
        }
//        +1 for "" empty string
        System.out.println(cnt + 1);
    }

    public static void main(String[] args) {
        DistinctCommonSubstring distinctCommonSubstring = new DistinctCommonSubstring();
        distinctCommonSubstring.countDistinctCommonSubstring("abab");
    }
}
