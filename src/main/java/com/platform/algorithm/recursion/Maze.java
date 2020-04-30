package com.platform.algorithm.recursion;

public class Maze {

    private int[][] map ;
    private  int sx,sy,ex,ey;

    public Maze(int x, int y){
        createMaze(x,y);
    }

    private void createMaze(int x, int y){
        map = new int[x][y];
        setFence();
    }

    private void setFence(){
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][map[0].length-1] = 1;
        }
        setSpecialFence();
    }

    private void setSpecialFence(){
        map[3][1] = 1;
        map[3][2] = 1;
    }

    public void display(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf("%d\t", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setPionts(int sx, int sy, int ex, int ey){
        this.sx = sx;
        this.sy = sy;
        this.ex = ex;
        this.ey = ey;
    }

    public boolean findRoad(int x, int y){
        if(x == ex && y == ey){
            map[x][y] = 2;
            display();
            return true;
        }
        if(map[x][y] == 0) {  // 1,2,3
            map[x][y] = 2;
            if (findRoad(x + 1, y))
                return true;
            else if (findRoad(x, y + 1))
                return true;
            else if (findRoad(x - 1, y))
                return true;
            else if (findRoad(x, y - 1))
                return true;
            else
                map[x][y] = 3;
        }

        return false;
    }


}
