package com.company;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    static int n=4;

    public static void printBoard(int[][] board){
        for(int[] i:board){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println("*******************");
    }
    public static void check(int[][] board, int col, int[] leftRow, int[] upperDiagonal, int[] lowerDaigonal){
        if(col==board.length){
            printBoard(board);
            return;
        }
        for (int row=0; row<board.length; row++){
            //checking if i can put queen here
            if(leftRow[row]==0 && lowerDaigonal[row+col]==0 && upperDiagonal[board.length-1+row-col]==0) {
                board[row][col]=1;
                leftRow[row]=-1;
                lowerDaigonal[row+col]=-1;
                upperDiagonal[board.length-1+row-col]=-1;
                check(board, col+1, leftRow, upperDiagonal, lowerDaigonal);
                leftRow[row]=0;
                lowerDaigonal[row+col]=0;
                upperDiagonal[board.length-1+row-col]=0;
                board[row][col]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board=new int[n][n];
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2*n-1];
        int lowerDiagonal[] = new int[2*n-1];
        check(board, 0, leftRow, upperDiagonal, lowerDiagonal);
    }
}

