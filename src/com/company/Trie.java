package com.company;

public class Trie {
    static Node root;

    Trie() {
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

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        if (node.isEnd()) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String seq) {
        Node node = root;
        for (int i = 0; i < seq.length(); i++) {
            if (!node.containsKey(seq.charAt(i))) {
                return false;
            }
            node = node.get(seq.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apps");
        System.out.println("search(app) : " + trie.search("app"));
        System.out.println("startsWith(app) : " + trie.startsWith("app"));
    }
}

class Node {
    Node links[] = new Node[26];
    boolean flg = false;

    Node() {
    }

    boolean containsKey(char ch) {
        return ((links[ch - 'a']) != null);
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flg = true;
    }

    boolean isEnd() {
        return flg;
    }
}

