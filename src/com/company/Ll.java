package com.company;

public class Ll {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    public Node head=null;
    public void insertEnd(int data){
        Node nn=new Node(data);
        if(head==null){
            head=nn;
        }
        else {
            Node curr=head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = nn;
        }
    }
    public void insertBeg(int data){
        Node nn=new Node(data);
        if(head==null){
            head=nn;
        }
        else {
            Node curr=head;
            head=nn;
            head.next=curr;
        }
    }
    public void insertAf(int data, int aValue){
        Node nn=new Node(data);
        Node curr=head;
        Node prev=null;
        while (curr.next != null && curr.data!=aValue) {
            prev=curr;
            curr = curr.next;
        }
        prev=prev.next;
        curr=curr.next;
        prev.next = nn;
        nn.next=curr;
    }
    public void disp(){
        Node curr=head;
        if(head==null){
            System.out.println("Empty");
        }
        else {
            while (curr.next != null) {
                System.out.println(curr.data);
                curr = curr.next;
            }
            System.out.println(curr.data);
        }
    }
    public void rev(){
        if(head==null){
            System.out.println("Empty");
        }
        else{
            Node prev = null;
            Node current = head;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
    }
    public static void main(String[] args) {
        Ll l=new Ll();
        l.insertEnd(1);
        l.insertEnd(3);
        l.insertEnd(2);
        l.insertBeg(7);
        l.insertAf(11,3);
        l.disp();
        l.rev();
        l.disp();
    }
}
