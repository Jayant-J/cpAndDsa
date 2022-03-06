package com.company;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    static int n = 4;
    static int visited[][] = new int[n][n];

    static void getPath(int[][] maze, int i, int j, List<Character> path) {
        if (i == n-1 && j == n-1) {
            System.out.println(path);
            return;
        } //Down
        if (i+1 < n && visited[i + 1][j] == 0 && maze[i + 1][j] == 1) {
            visited[i + 1][j] = 1;
            path.add('D');
            getPath(maze, i + 1, j, path);
            visited[i + 1][j] = 0;
            path.remove(path.size()-1);
        } //Left
        if (j+1 < n && visited[i][j + 1] == 0 && maze[i][j + 1] == 1) {
            visited[i][j + 1] = 1;
            path.add('L');
            getPath(maze, i, j + 1, path);            visited[i][j + 1] = 1;
            visited[i][j + 1] = 0;
            path.remove(path.size()-1);
        }//Right
        if (i-1 > 0 && visited[i - 1][j] == 0 && maze[i - 1][j] == 1) {
            visited[i - 1][j] = 1;
            path.add('R');
            getPath(maze, i - 1, j, path);
            visited[i - 1][j] = 0;
            path.remove(path.size()-1);
        }//Up
        if (j-1 > 0 && visited[i][j - 1] == 0 && maze[i][j - 1] == 1) {
            visited[i][j - 1] = 1;
            path.add('U');
            getPath(maze, i, j - 1, path);
            visited[i][j - 1] = 0;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };
        List<Character> path = new ArrayList<>();
        getPath(maze, 0, 0, path);
    }
}
