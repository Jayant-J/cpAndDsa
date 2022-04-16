package com.company;

public class TrieCount {
    NodeCount root;

    TrieCount() {
        root = new NodeCount();
    }

    public void insert(String word) {
        NodeCount node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new NodeCount());
            }
            node = node.get(word.charAt(i));
            node.countPrefix++;
        }
        node.endWith++;
        node.setEnd();
    }

    public int wordCount(String word) {
        NodeCount node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.endWith;
    }

    public int startsWithCount(String seq) {
        NodeCount node = root;
        for (int i = 0; i < seq.length(); i++) {
            if (!node.containsKey(seq.charAt(i))) {
                return 0;
            }
            node = node.get(seq.charAt(i));
        }
        return node.countPrefix;
    }

    public void erase(String word) {
        NodeCount node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return;
            }
            node = node.get(word.charAt(i));
            node.countPrefix--;
        }
        node.endWith--;
    }

    public static void main(String[] args) {
        TrieCount trieCount = new TrieCount();
        trieCount.insert("apple");
        trieCount.insert("apple");
        trieCount.insert("apps");
        trieCount.insert("apps");
        System.out.println("trieCount.wordCount(apple) :" + trieCount.wordCount("apple"));
        System.out.println("trieCount.wordCount(app) :" + trieCount.wordCount("app"));
        System.out.println("trieCount.startsWithCount(app) :" + trieCount.startsWithCount("app"));
        trieCount.erase("apple");
    }
}

class NodeCount {

    NodeCount[] links = new NodeCount[26];
    int endWith = 0;
    int countPrefix = 0;
    boolean flg = false;

    NodeCount() {
    }

    boolean containsKey(char ch) {
        return ((links[ch - 'a']) != null);
    }

    NodeCount get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, NodeCount node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flg = true;
    }

    boolean isEnd() {
        return flg;
    }

}