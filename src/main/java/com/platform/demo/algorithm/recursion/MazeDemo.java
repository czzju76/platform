package com.platform.demo.algorithm.recursion;

import com.platform.algorithm.recursion.Maze;

public class MazeDemo {
    public static void main(String[] args) {
        Maze maze = new Maze(10,9);
        maze.setPionts(1,1,8,7);
        maze.display();
        maze.findRoad(1,1);
    }
}
