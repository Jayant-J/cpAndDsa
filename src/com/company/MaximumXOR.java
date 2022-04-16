package com.company;

public class MaximumXOR {
    NodeBinary root;

    MaximumXOR() {
        root = new NodeBinary();
    }

    public void insert(int number) {
        NodeBinary node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (number >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new NodeBinary());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int number) {
        NodeBinary node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (number >> i) & 1;
            if (!node.containsKey(1 - bit)) {
                node = node.get(bit);
            } else {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        MaximumXOR maximumXOR = new MaximumXOR();
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {1, 2, 3, 4, 5};
        for (int it : arr1) {
            maximumXOR.insert(it);
        }
        int maxi = 0;
        for (int it : arr2) {
            maxi = Math.max(maxi, maximumXOR.getMax(it));
        }
        System.out.println(maxi);
    }
}

class NodeBinary {
    NodeBinary[] links = new NodeBinary[2];

    NodeBinary() {
    }

    boolean containsKey(int ind) {
        return (links[ind] != null);
    }

    NodeBinary get(int ind) {
        return links[ind];
    }

    void put(int ind, NodeBinary node) {
        links[ind] = node;
    }
}
