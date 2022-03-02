package com.company;

import java.util.*;

class Node {
    int val;
    Node l;
    Node r;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node l, Node r) {
        this.val = val;
        this.l = l;
        this.r = r;
    }
}

class Pair {
    Node node;
    int num;
    Pair(Node _node, int _num) {
        num = _num;
        node = _node;
    }
}
class Tuple{
    Node node;
    int vertical;
    int level;
    Tuple(Node node, int vertical, int level){
        this.node=node;
        this.level=level;
        this.vertical =vertical;
    }
}

public class Traversals {
    public static void inOrderRecursion(Node n) {
        if (n == null) {
            return;
        }
        inOrderRecursion(n.l);
        System.out.print(n.val + " ");
        inOrderRecursion(n.r);
    }

    public static void inorderIterative(Node n) {
        if (n == null)
            return;
        Stack<Node> stack = new Stack<>();
        while (true) {
            if (n != null) {
                stack.push(n);
                n = n.l;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                n = stack.pop();
                System.out.print(n.val + " ");
                n = n.r;
            }
        }
    }

    public static List<Integer> postOrderTraversal(Node root) {
        Stack<Node> st1 = new Stack<>();
        List<Integer> postOrder = new ArrayList<>();

        if (root == null) return postOrder;

        Node current = root;
        while (current != null || !st1.isEmpty()) {
            if (current != null) {
                st1.push(current);
                current = current.l;
            } else {
                Node temp = st1.peek().r;
                if (temp == null) {
                    temp = st1.pop();
                    postOrder.add(temp.val);
                    while (!st1.isEmpty() && temp == st1.peek().r) {
                        temp = st1.pop();
                        postOrder.add(temp.val);
                    }
                } else {
                    current = temp;
                }
            }
        }
        return postOrder;
    }

    public static void allTraversal(Node root) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if (root == null)
            return;

        while (!st.isEmpty()) {
            Pair it = st.pop();

            // this is part of pre
            // increment 1 to 2
            // push the left side of the tree
            if (it.num == 1) {
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.l != null) {
                    st.push(new Pair(it.node.l, 1));
                }
            }

            // this is a part of in
            // increment 2 to 3
            // push right
            else if (it.num == 2) {
                in.add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.r != null) {
                    st.push(new Pair(it.node.r, 1));
                }
            }
            // don't push it back again
            else {
                post.add(it.node.val);
            }
        }

        System.out.println("InOrder : " + in);
        System.out.println("PreOrder : " + pre);
        System.out.println("PostOrder : " + post);

    }

    public static List<List<Integer>> levelOrder(Node n) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> mainList = new ArrayList<>();
        if (n == null) {
            return mainList;
        }
        q.offer(n);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (q.peek().l != null)
                    q.offer(q.peek().l);
                if (q.peek().r != null)
                    q.offer(q.peek().r);
                subList.add(q.poll().val);
            }
            mainList.add(subList);
        }
        System.out.print("Left View : ");
        for (List<Integer> i : mainList) {
            System.out.print(i.get(0) + " ");
        }
        System.out.println();
        System.out.print("Right View : ");
        for (List<Integer> i : mainList) {
            System.out.print(i.get(i.size() - 1) + " ");
        }
        System.out.println();
        System.out.println("Depth : " + mainList.size());
        return mainList;
    }

    public static int maximumDepth(Node n) {
        if (n == null)
            return 0;
        int heightLeft = maximumDepth(n.l);
        int heightRight = maximumDepth(n.r);
        return 1 + Math.max(heightLeft, heightRight);
    }

    public static int checkIfBalanced(Node n) {
        if (n == null) {
            return 0;
        }
        int heightLeft = maximumDepth(n.l);
        if (heightLeft == -1)
            return -1;
        int heightRight = maximumDepth(n.r);
        if (heightRight == -1)
            return -1;
        if (Math.abs(heightLeft - heightRight) > 1)
            return -1;
        return Math.max(heightLeft, heightRight) + 1;
    }

    public static int maxDia(Node n, int[] maxi) {
        if (n == null)
            return 0;
        int leftHeight = maxDia(n.l, maxi);
        int rightHeight = maxDia(n.r, maxi);
        maxi[0] = Math.max(leftHeight + rightHeight, maxi[0]);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int maxPathSum(Node n, int[] maxi) {
        if (n == null)
            return 0;
        int sumLeft = maxPathSum(n.l, maxi);
        int sumRight = maxPathSum(n.r, maxi);
        maxi[0] = Math.max(maxi[0], sumLeft + sumRight + n.val);
        return n.val + Math.max(sumLeft, sumRight);
    }

    public static Boolean isIdentical(Node n1, Node n2) {
        if (n1 == null || n2 == null)
            return n1 == n2;
        return n1.val == n2.val && isIdentical(n1.l, n2.l) && isIdentical(n1.r, n2.r);
    }

    public static void zigzagTraversal(Node n, boolean leftToRight) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> mainList = new ArrayList<>();
        if (n == null)
            return;
        q.offer(n);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (q.peek().l != null)
                    q.offer(q.peek().l);
                if (q.peek().r != null)
                    q.offer(q.peek().r);
                subList.add(q.poll().val);
            }
            if (leftToRight)
                mainList.add(subList);
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = subList.size() - 1; i >= 0; i--) {
                    temp.add(subList.get(i));
                }
                mainList.add(temp);
            }
            leftToRight = !leftToRight;
        }
        System.out.println(mainList);
    }

    public static void boundaryTraversal(Node n) {
        if (n== null)
            return;
        //fisrt get left without leaf
        //inOrder to get leaf
        //then right to without leaf
        List<Integer> res=new ArrayList<>();
        if (!(n.l == null && n.r == null)) {   //ie not leaf
            res.add(n.val);
        }
        addLeft(n, res);
        addLeaves(n, res);
        addRight(n, res);
        System.out.println(res);
    }
    public static void addLeft(Node n, List<Integer> res) {
        Node curr = n.l;
        while (curr != null) {
            if (!(curr.l == null && curr.r == null)) {   //ie not leaf
                res.add(curr.val);
            }
            if (curr.l != null)
                curr = curr.l;
            else
                curr = curr.r;
        }
    }
    public static void addRight(Node n, List<Integer> res) {
        Node curr = n.r;
        while (curr != null) {
            if (!(curr.l == null && curr.r == null)) {   //ie not leaf
                res.add(curr.val);
            }
            if (curr.r != null)
                curr = curr.r;
            else
                curr = curr.l;
        }
    }
    public static void addLeaves(Node n, List<Integer> res) {
        if ((n.l == null && n.r == null)) {   //ie  leaf
            res.add(n.val);
            return;
        }
        if (n.l != null)
            addLeaves(n.l, res);
        if(n.r!=null)
            addLeaves(n.r, res);
    }

    public static void verticalOrder(Node n, List<Tuple> list, int vertical, int level){
        if(n==null)
            return;
        //just doing in order traversal with position
        verticalOrder(n.l, list, vertical-1, level+1);
        list.add(new Tuple(n, vertical, level));
        verticalOrder(n.r, list, vertical+1, level+1);
    }
    public static void getBottomView(List<Tuple> list){
        Map<Integer, Tuple> map=new HashMap<>();
        for(Tuple t: list){
            if(map.get(t.vertical)==null){
                map.put(t.vertical, t);
            } else {
                if (map.get(t.vertical).level < t.level) {
//                if (map.get(t.vetrical).level > t.level) { FOR TOP VIEW
                    map.put(t.vertical, t);
                }
            }
        }
        for(Map.Entry<Integer, Tuple> ele:map.entrySet()) {
            System.out.print(ele.getValue().node.val+" ");
        }
    }

    public static boolean isSymmetric(Node left, Node right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetric(left.l, right.r) && isSymmetric(left.r, right.l);
    }

    public static boolean rootToNode(Node root, int x, List<Integer> list){
        if(root==null)
            return false;
        list.add(root.val);
        if(root.val==x){
            return true;
        }
        if(rootToNode(root.l, x, list) || rootToNode(root.r, x, list))
            return true;
        list.remove(list.size()-1);
        return false;
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q){
        if(root==null || root==p || root== q){
            return root;
        }
        Node left=lowestCommonAncestor(root.l, p,q);
        Node right=lowestCommonAncestor(root.r, p,q);
        if(left==null)
            return right;
        else if(right==null)
            return left;
        else
            return root;
    }

    public static int maximumWidth(Node n){
        if(n==null)
            return 0;
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(n, 0));
        while(!q.isEmpty()){
            int size=q.size();
            int mmin=q.peek().num;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                int cur_id=q.peek().num-mmin;
                Node node=q.peek().node;
                q.poll();
                if(i==0)
                    first=cur_id;
                if(i==size-1)
                    last=cur_id;
                if(node.l!=null)
                    q.offer(new Pair(node.l, cur_id*2+1));
                if(node.r!=null)
                    q.offer(new Pair(node.r, cur_id*2+2));
            }
            ans=Math.max(ans, last-first+1);
        }
        return ans;
    }

    public static void childSumTree(Node n){
        if(n==null)
            return;
        int child=0;
        if(n.l!=null)
            child+=n.l.val;
        if(n.r!=null)
            child+=n.r.val;
        if(child>=n.val)
            n.val=child;
        else {
            if(n.l!=null)
                n.l.val=n.val;
            else if(n.r!=null)
                n.r.val=n.val;
        }

        childSumTree(n.l);
        childSumTree(n.r);

        int tot=0;
        if(n.l!=null)
            tot+=n.l.val;
        if(n.r!=null)
            tot+=n.r.val;
        if(n.l!=null || n.r!=null)
            n.val=tot;
    }

    public static void getAllAtDistanceK(Node root, Node n, int k){
        if(n==null){
            return;
        }
        int dist=0;
        Map<Node, Node> parent=getParents(root);
        Map<Node, Boolean> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(n);
        visited.put(n, true);
        while (!q.isEmpty()){
            int size=q.size();
            if(dist==k){
                break;
            }
            dist++;
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(curr.l!=null && visited.get(curr.l)==null){
                    q.offer(curr.l);
                    visited.put(curr.l, true);
                }
                if(curr.r!=null && visited.get(curr.r)==null){
                    q.offer(curr.r);
                    visited.put(curr.r, true);
                }
                if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr), true);
                }
            }
        }
        for(Node node:q){
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
    public static Map<Node, Node> getParents(Node n){
        Queue<Node> q=new LinkedList<>();
        Map<Node, Node> parents=new HashMap<>();
        q.offer(n);
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.l!=null){
                parents.put(curr.l, curr);
                q.offer(curr.l);
            }
            if(curr.r!=null){
                parents.put(curr.r, curr);
                q.offer(curr.r);
            }
        }
        return parents;
    }

    public static void timeToBurn(Node root, Node n){
        if(n==null){
            return;
        }
        int dist=0;
        Map<Node, Node> parent=getParents(root);
        Map<Node, Boolean> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(n);
        visited.put(n, true);
        while (!q.isEmpty()){
            int size=q.size();
            int flg=0;
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(curr.l!=null && visited.get(curr.l)==null){
                    flg=1;
                    q.offer(curr.l);
                    visited.put(curr.l, true);
                }
                if(curr.r!=null && visited.get(curr.r)==null){
                    flg=1;
                    q.offer(curr.r);
                    visited.put(curr.r, true);
                }
                if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                    flg=1;
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr), true);
                }
            }
            if(flg==1)
                dist++;
        }
        System.out.println(dist);
    }

    public static int nodesInCompleteTree(Node n){
        if(n==null)
            return 0;
        int leftHeight=0;
        Node nodeLeft=n;
        int rightHeight=0;
        Node nodeRight=n;
        while(nodeLeft.l!=null){
            nodeLeft=nodeLeft.l;
            leftHeight++;
        }
        while(nodeRight.l!=null){
            nodeRight=nodeRight.l;
            rightHeight++;
        }
        if(leftHeight==rightHeight){
            return (2<<leftHeight) -1;
        } else {
            return nodesInCompleteTree(n.l)+nodesInCompleteTree(n.r)+1;
        }
    }

    public static Node constructTreeFromInAndPre(int[] pre,int preStart, int preEnd,
                                                 int in[], int inStart, int inEnd,
                                                 Map<Integer, Integer> imMap){
        if(preStart> preEnd || inStart>inEnd){
            return null;
        }
        Node root=new Node(pre[preStart]);
        int inRoot=imMap.get(root.val);
        int numLeft=inRoot-inStart;      //numbers on left
        root.l=constructTreeFromInAndPre(pre, preStart+1, preStart+numLeft,
                in, inStart, inRoot-1, imMap);
        root.r=constructTreeFromInAndPre(pre, preStart+numLeft+1, preEnd,
                in, inRoot+1, inEnd, imMap);
        return root;
    }

    public static Node constructTreeFromInAndPost(int[] post,int postStart, int postEnd,
                                                 int in[], int inStart, int inEnd,
                                                 Map<Integer, Integer> imMap){
        if(postStart> postEnd || inStart>inEnd){
            return null;
        }
        Node root=new Node(post[postEnd]);
        int inRoot=imMap.get(root.val);
        int numLeft=inRoot-inStart;      //numbers on right
        root.l=constructTreeFromInAndPost(post, postStart, postStart+numLeft-1,
                in, inStart, inRoot-1, imMap);
        root.r=constructTreeFromInAndPost(post, postStart+numLeft, postEnd-1 ,
                in, inRoot+1, inEnd, imMap);
        return root;
    }

    public static String serialize(Node root){
        String s="";
        if(root==null)
            return s;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node== null){
                s+="# ";
                continue;
            }
            s+=node.val+" ";
            q.offer(node.l);
            q.offer(node.r);
        }
        return s;
    }
    public static Node deSerialize(String s){
        if(s.equals("") || s==null){
            return null;
        }
        String[] ele=s.split(" ");
        Node root=new Node(Integer.parseInt(ele[0]));
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        for(int i=1;i<ele.length;i++){
            Node parent=q.poll();
            if(!ele[i].equals("#")){
                Node left=new Node(Integer.parseInt(ele[i]));
                parent.l=left;
                q.offer(left);
            }
            if(!ele[++i].equals("#")){
                Node right=new Node(Integer.parseInt(ele[i]));
                parent.r=right;
                q.offer(right);
            }
        }
        return root;
    }

    public static void morrisInOrder(Node n){
        List<Integer> list=new ArrayList<>();
        Node curr=n;
        while(curr!=null){
            if(curr.l==null){
                list.add(curr.val);
                curr=curr.r;
            } else {
                Node prev = curr.l;
                while(prev.r!=null && prev.r != curr){
                    prev=prev.r;
                }
                if(prev.r==null){           //For PreOrder
                    prev.r=curr;
//                    list.add(curr.val)      Add this
                    curr=curr.l;
                } else {
                    prev.r=null;
                    list.add(curr.val);     //remove this
                    curr=curr.r;
                }
            }
        }
        System.out.println(list);
    }


    static Node previous = null;
    public static void flattenBT(Node root) {
        if(root == null) return;

        flattenBT(root.r);
        flattenBT(root.l);

        root.r = previous;
        root.l = null;
        previous = root;
    }

    public static void main(String[] args) {
        Node n4 = new Node(4);                //           1
        Node n5 = new Node(5);                //          / \
        Node n6 = new Node(6);                //         2   3
        Node n7 = new Node(7);                //        / \  / \
        Node n2 = new Node(2, n4, n5);        //       4  5 6   7
        Node n3 = new Node(3, n6, n7);        //
        Node n1 = new Node(1, n2, n3);        //

        Node t2 = new Node(2);                //      1
        Node t8 = new Node(8);                //     / \
        Node t9 = new Node(9);                //    2   3
        Node t5 = new Node(5, t9, null);   //       / \
        Node t4 = new Node(4, t5, null);   //      4   6
        Node t7 = new Node(7, null, t8);   //     /     \
        Node t6 = new Node(6, null, t7);   //    5       7
        Node t3 = new Node(3, t4, t6);        //   /        \
        Node t1 = new Node(1, t2, t3);        //  9          8

        System.out.print("inOrderRecursion(n1) : ");
        inOrderRecursion(n1);
        System.out.println();
        System.out.print("inOrderIteration(n1) : ");
        inorderIterative(n1);
        System.out.println();
        System.out.print("postOrder(n1) : ");
        System.out.println(postOrderTraversal(n1));
        System.out.println();
        System.out.println("All Traversals : ");
        allTraversal(n1);

        System.out.print("levelOrder(n1) : ");
        System.out.println(levelOrder(n1));

        System.out.print("Depth(n1) : ");
        System.out.println(maximumDepth(n1));
        System.out.print("checkIfBalanced(n1) : ");
        System.out.println(checkIfBalanced(n1) == -1 ? false : true);
        System.out.print("maxDiameter(n1) : ");
        int[] dia = new int[1];
        maxDia(n1, dia);
        System.out.println(dia[0] + 1);
        System.out.print("maxPathSum(n1) : ");
        int maxVal[] = new int[1];
        maxPathSum(n1, maxVal);
        System.out.println(maxVal[0]);
        System.out.println("isIdentical(n1, t1)");
        System.out.print(isIdentical(n1, t1));

        System.out.println("Zigzag order(n1) : ");
        zigzagTraversal(n1, true);

        System.out.println("Boundary : ");
        boundaryTraversal(n1);

        System.out.println("Vertical Order : ");
        List<Tuple> list=new ArrayList<>();
        verticalOrder(n1, list, 0, 0);
        list.stream().forEach(t-> System.out.println(t.node.val + ":" + t.vertical + ":" + t.level));
        System.out.println("BottomView : ");
        getBottomView(list);

        System.out.println("Symmetric Tree : ");
        System.out.println(isSymmetric(n1.l, n1.r));

        System.out.println("Root to Node Path");
        List<Integer> path=new ArrayList<>();
        if(rootToNode(n1, 7, path))
            System.out.println(path);
        else
            System.out.println("No Path");

        System.out.println("Lowest common ancestor");
        System.out.println(lowestCommonAncestor(n1, n3, n5).val);

        System.out.println("Maximum Width");
        System.out.println(maximumWidth(n1));

        System.out.println("getAllAtDistanceK");
        getAllAtDistanceK(n1, n2, 2);

        System.out.println("timeToBurnAll");
        timeToBurn(n1, n1);

        System.out.println("NodesInCompleteTree");
        System.out.println(nodesInCompleteTree(n1));

        Map<Integer, Integer> inMap=new HashMap<>();
        int[] inOrder={9,3,15,20,7};
        int[] preOrder={3,9,20,15,7};
        int[] postOrder={9,15,7,20,3};
        for(int i=0;i<inOrder.length;i++)
            inMap.put(inOrder[i], i);
        System.out.println("constructTreeFromInAndPre");
        Node one=constructTreeFromInAndPre(preOrder, 0, preOrder.length-1,
                inOrder, 0, inOrder.length-1, inMap);
        System.out.println("constructTreeFromInAndPost");
        Node two=constructTreeFromInAndPost(postOrder, 0, postOrder.length-1,
                inOrder, 0, inOrder.length-1, inMap);

        System.out.println("Serialize & Deserialize");
        String s=serialize(n1);
        System.out.println(s);
        Node three=deSerialize(s);

        System.out.println("MorrisTraversal");
        morrisInOrder(n1);

        System.out.println("Flatten a BT");
        flattenBT(n1);

    }
}
