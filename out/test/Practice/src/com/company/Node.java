package com.company;

public class Node
{
    private int v;
    private int weight;

    Node(int _v, int _w) { v = _v; weight = _w; }

    Node() {}

    int getV() { return v; }
    int getWeight() { return weight; }
}