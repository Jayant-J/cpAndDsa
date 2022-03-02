package com.company;

public class Queues {
    int Max=10;
    int front=-1;
    int rear=0;
    int items[]=new int[Max];
    void en(int ele){
        if(rear==Max-1){
            System.out.println("F");
        }
        else{
            items[rear]=ele;
//            rear=(rear+1)%Max;
        }
    }
    void de(){
        if(front==rear-1){
            System.out.println("E");
        }
        else{
            ++front;
//            front=(front+1)%Max;
        }
    }
    public static void main(String[] args) {
        Queues q=new Queues();
    }
}
