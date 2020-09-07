package com.lsj.springboot.Util.arithmetic.day200818;

/**
 * Created by 10326 on 2020/9/7.
 * 题目463：岛屿的周长
 *
 * 题目200：岛屿数量
 *
 * 题目695：岛屿的最大面积
 */
public class DFS {
    /**
     * 463. 岛屿的周长
     * 网络的深度优先搜索问题
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
     * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
     * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     * 输入:[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]输出: 16
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    return islandPerimeter(grid, r, c);
                }
            }
        }
        return 0;
    }

    public int islandPerimeter(int[][] grid, int r, int c){
        if(!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)){
            return 1;// 从岛屿移动到边界外 +1
        }
        if(grid[r][c] == 0){
            return 1;// 从岛屿移动到水域 +1
        }
        if(grid[r][c] == 2){// 已经算过的节点不在参与运算
            return 0;
        }
        grid[r][c] = 2;
        // 前后左右4个节点
        return islandPerimeter(grid, r - 1, c) + islandPerimeter(grid, r + 1, c) +
                islandPerimeter(grid, r, c - 1) + islandPerimeter(grid, r, c + 1);
    }


    /**
     * 200. 岛屿数量
     * 网络的深度优先搜索问题
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。此外，你可以假设该网格的四条边均被水包围。
     * [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]            输出：3
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    islandPerimeter(grid, r, c);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void islandPerimeter(char[][] grid, int r, int c){
        if(!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)){
            return;//岛外return
        }
        if(grid[r][c] != '1'){
            return;// 水域或者走过的岛屿return
        }
        grid[r][c] = '2';
        // 前后左右4个节点
        islandPerimeter(grid, r - 1, c);
        islandPerimeter(grid, r + 1, c);
        islandPerimeter(grid, r, c - 1);
        islandPerimeter(grid, r, c + 1);
    }

    /**
     * 695. 岛屿的最大面积
     * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
     * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],
     * [0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 输出 6
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    ans = Math.max(islandPerimeter0(grid, r, c), ans);
                }
            }
        }
        return ans;
    }

    public int islandPerimeter0(int[][] grid, int r, int c){
        if(!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)){
            return 0;//岛外return
        }
        if(grid[r][c] != 1){
            return 0;// 水域或者走过的岛屿return
        }
        grid[r][c] = 2;
        // 前后左右4个节点
        return 1 + islandPerimeter0(grid, r - 1, c) + islandPerimeter0(grid, r + 1, c) +
                islandPerimeter0(grid, r, c - 1) + islandPerimeter0(grid, r, c + 1);
    }
}
