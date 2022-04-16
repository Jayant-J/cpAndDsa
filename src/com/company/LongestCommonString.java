package com.company;

public class LongestCommonString {
    Node root;

    LongestCommonString() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!(node.containsKey(word.charAt(i)))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean ifPrefixExist(String seq) {
        Node node = root;
        for (int i = 0; i < seq.length(); i++) {
            if (!node.containsKey(seq.charAt(i))) {
                return false;
            }
            node = node.get(seq.charAt(i));
            if (node.isEnd() == false) {
                return false;
            }
        }
        return true;
    }

    public void getLCS(String[] arr) {
        String longest = "";
        for (String s : arr) {
            if (ifPrefixExist(s)) {
                if (s.length() > longest.length())
                    longest = s;
                if (s.length() == longest.length() && s.compareTo(longest) < 0)
                    longest = s;
            }
        }
        if (longest == "")
            System.out.println("NA");
        else
            System.out.println(longest);
    }

    public static void main(String[] args) {
        LongestCommonString longestCommonString = new LongestCommonString();
        String arr[] = {"n", "ni", "nin", "ninj", "ninja", "ninga"};
        for (String s : arr) {
            longestCommonString.insert(s);
        }
        longestCommonString.getLCS(arr);
    }
}
