package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class NodeValue{
    int max, min, size;
    NodeValue(int max, int min, int size){
        this.max=max;
        this.min=min;
        this.size=size;
    }
}

public class BST {

    public static Node createBST(int[] ele) {
        Node root = new Node(ele[0]);
        for (int i = 1; i < ele.length; i++) {
            Node curr = root;
            Node prev = curr;
            while (curr != null) {
                prev = curr;
                if (curr.val > ele[i]) {
                    curr = curr.l;
                } else if (curr.val < ele[i]) {
                    curr = curr.r;
                }
            }
            if (prev.val > ele[i])
                prev.l = new Node(ele[i]);
            else
                prev.r = new Node(ele[i]);
        }
        return root;
    }

    public static Node searchInBST(Node root, int key) {
//        if (root != null && root.val != key) {
//            root = (key < root.val) ? root.l : root.r;
//        }
//        return root;
        if (root == null)
            return null;
        if (root.val > key)
            return searchInBST(root.l, key);
        else if (root.val < key)
            return searchInBST(root.r, key);
        else
            return root;
    }

    public static int findCeil(Node root, int key) {
        if (root == null)
            return -1;
        int ceil = -1;
        while (root != null) {
            if (root.val == key) {
                ceil = root.val;
                break;
            }
            if (root.val < key) {
                root = root.r;
            } else {
                ceil = root.val;
                root = root.l;
            }
        }
        return ceil;
    }

    public static int findFloor(Node root, int key) {
        if (root == null)
            return -1;
        int floor = -1;
        while (root != null) {
            if (root.val == key) {
                floor = root.val;
                return floor;
            }
            if (key > root.val) {
                floor = root.val;
                root = root.r;
            } else {
                root = root.l;
            }
        }
        return floor;
    }

    public static void insertANode(Node root, int val){
        if(root==null)
            return;
        Node cur=root;
        while(true){
            if(cur.val<=val){
                if(cur.r!=null)
                    cur=cur.r;
                else{
                    cur.r=new Node(val);
                    break;
                }
            } else{
                if(cur.l!=null)
                    cur=cur.l;
                else {
                    cur.l = new Node(val);
                    break;
                }
            }
        }
    }

    public static Node deleteANode(Node root, int val){
        if(root==null)
            return null;
        Node dummy=root;
        while (root!=null){
            if(root.val==val)
                return helper(root);
            if(root.val>val){
                root=root.l;
            }else {
                root=root.r;
            }
        }
        return dummy;
    }
    public static Node helper(Node node){
        if(node.l==null)
            return node.r;
        else if(node.r==null)
            return node.l;
        else{
            Node rightChild=node.r;
            Node lastRight=getLastRight(node.l);
            lastRight.r=rightChild;
            return node.l;
        }
    }
    public static Node getLastRight(Node node){
        while(node.r!=null){
            node= node.r;
        }
        return node;
    }

    public static int counter=0;
    public static void kthSmallestEle(Node root, int k){

        if (root==null)
            return;
        kthSmallestEle(root.l, k);
        counter++;
        if(counter==k){
            System.out.println(root.val);
            return;
        }
        kthSmallestEle(root.r, k);
    }

    public static boolean validBST(Node root, int max, int min){
        if(root==null){
            return true;
        }
        if(root.val>=max || root.val>=min)
            return false;
        return validBST(root.l, root.val, min) && validBST(root.r, max, root.val);
    }

    public static int lcaInBST(Node root, Node p, Node q){
        if(root==null || root.val==p.val || root.val==q.val){
            return root.val;
        }
        while(true){
            if(root.val>p.val && root.val>q.val){
                root=root.l;
            }
            else if(root.val<p.val && root.val<q.val){
                root=root.r;
            } else {
                break;
            }
        }
        return root.val;
    }

    public static Node constructBSTFromPreorder(int[] pre){
        int[] in= Arrays.copyOf(pre, pre.length);
        Arrays.sort(in);
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<in.length;i++)
            map.put(in[i], i);
        return getTree(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }
    public static Node getTree(int[] pre, int preSt, int preEnd,
                               int[] in, int inSt, int inEnd, Map<Integer, Integer> map){
        if(preSt> preEnd || inSt>inEnd){
            return null;
        }
        Node node=new Node(pre[preSt]);
        int rootInd=map.get(node.val);
        int numLeft=rootInd-inSt;

        node.l=getTree(pre, preSt+1, preEnd+numLeft, in, inSt, rootInd-1, map);
        node.r=getTree(pre, preSt+numLeft+1, preEnd, in, rootInd+1, inEnd, map);
        return node;
    }

    public static int inOrderSuccessor(Node root, int key){
        if(root==null)
            return -1;
        int successor=-1;
        while(root!=null){
            if(key>=root.val){
                root=root.r;
            } else {
                successor=root.val;
                root=root.l;
            }
        }
        return successor;
    }

    public static int inOrderPredecessor(Node root, int key){
        if(root==null)
            return -1;
        int predecessor=-1;
        while(root!=null){
            if(key<=root.val){
                root=root.l;
            } else {
                predecessor=root.val;
                root=root.r;
            }
        }
        return predecessor;
    }

    public static Node first, last, middle, prev;
    public static void recoverTree(Node root){
        first=last=middle=null;
        prev=new Node(Integer.MIN_VALUE);
        inOrderToRecover(root);
        if(first!=null && last!=null){
            int t=first.val;
            first.val= last.val;
            last.val=t;
        } else if(first!=null && middle!=null){     //case of Adjacent swap
            int t=first.val;
            first.val= middle.val;
            middle.val=t;
        }
    }
    public static void inOrderToRecover(Node root){
        if(root==null)
            return;
        inOrderToRecover(root.l);

        if(prev!=null && (root.val<prev.val)){
            if(first==null){
                first=prev;
                middle=root;
            } else
                last=root;
        }

        inOrderToRecover(root.r);
    }

//    class NodeValue{
//        int max, min, size;
//        NodeValue(int max, int min, int size){
//            this.max=max;
//            this.min=min;
//            this.size=size;
//        }
//    }
    public static NodeValue largestBstSize(Node node){
        if(node==null){
            return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE, 0);
        }
        NodeValue left=largestBstSize(node.l);
        NodeValue right=largestBstSize(node.r);

        if(left.max<node.val && node.val<right.min){
            return new NodeValue(Math.max(node.val, right.max),
                    Math.min(node.val, left.min),
                    left.size+right.size+1);
        }
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.max, right.max));
    }



    public static void main(String[] args) {
        Node n1 = new Node(1);                //           4
        Node n3 = new Node(3);                //          / \
        Node n5 = new Node(5);                //         2   6
        Node n7 = new Node(7);                //       / \  / \
        Node n2 = new Node(2, n1, n3);        //      1  3 5   7
        Node n6 = new Node(6, n5, n7);        //
        Node n4 = new Node(4, n2, n6);        //

        int[] ele = {4, 2, 6, 1, 3, 5, 7};

        System.out.println("CreatingBST");
        Node bst = createBST(ele);

        System.out.println("Searching in BST");
        System.out.println(searchInBST(n4, 7));

        System.out.println("Find ceil in BST");
        System.out.println(findCeil(createBST(new int[]{10, 8, 12, 13, 15}), 14));
        System.out.println("Find floor in BST");
        System.out.println(findFloor(createBST(new int[]{10, 8, 12, 13, 15}), 14));

        System.out.println("Insert a node");
        insertANode(bst, 10);

        System.out.println("Delete a node");
        deleteANode(bst, 5);

        System.out.println("Kth smallest ele");
        kthSmallestEle(n4, 7);

        System.out.println("Validate a bst:");
        System.out.println("is n4 bst valid : "+validBST(n4, Integer.MAX_VALUE, Integer.MIN_VALUE));

        System.out.println("Least Common Ancestor in a bst:");
        System.out.println(lcaInBST(n4, n5, n6));

        System.out.println("BST from Pre Order Traversal");
        constructBSTFromPreorder(new int[]{8,5,1,7,10,12});

        System.out.println("InOrder Successor : " + inOrderSuccessor(n4, 5));//ceil
        System.out.println("InOrder Predecessor : " + inOrderPredecessor(n4, 5));//floor

        System.out.println("BST Iterator"); //refer ss;

        System.out.println("Inorder to recover");
        recoverTree(n4);

        System.out.println("Largest BST in a BT");
        System.out.println(largestBstSize(n4).size);

    }
}
