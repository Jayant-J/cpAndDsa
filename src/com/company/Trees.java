package com.company;

public class Trees {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    Node insert(Node root,int d){
        if(root==null)
            root.data=d;
        else{
            if(root.data>d){
                root.left=insert(root.left, d);
            }
            else if(root.data>d){
                root.right=insert(root.right, d);
            }
        }
        return root;
    }
    void disp(Node root){
        if(root!=null){
            disp(root.left);
            System.out.println(root.data);
            disp(root.right);
        }
    }
    static Node root;

    public static void main(String[] args) {
        Trees t=new Trees();
        t.insert(root,1);
        t.insert(root,2);
        t.insert(root,3);
        t.insert(root,4);
        t.insert(root,5);
        t.disp(root);
    }
}
