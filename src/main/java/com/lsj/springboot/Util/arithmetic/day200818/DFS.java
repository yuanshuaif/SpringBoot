package com.lsj.springboot.Util.arithmetic.day200818;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 10326 on 2020/9/7.
 * 题目463：岛屿的周长
 *
 * 题目200：岛屿数量
 *
 * 题目695：岛屿的最大面积
 *
 * 面试题 16.19. 水域大小
 *
 * 题目79：单词搜索
 *
 * 题目130:被围绕的区域
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

    /**
     * 面试题 16.19. 水域大小
     * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。
     * 由垂直、水平或对角连接的水域为池塘。
     * 池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
     * 输入：
     * [[0,2,1,0],
     * [0,1,0,1],
     * [1,1,0,1],
     * [0,1,0,1]]    输出： [1,2,4]
     * @param land
     * @return
     */
    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for(int r = 0; r < land.length; r++){
            for(int c = 0; c < land[0].length; c++){
                if(land[r][c] == 0){
                    list.add(pondSizes(land, r, c));
                }
            }
        }
        Integer[] temp = list.toArray(new Integer[0]);
        int[] ans = new int[temp.length];
        for(int i = 0; i < temp.length; i++){
            ans[i] = temp[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    public int pondSizes(int[][] land, int r, int c) {
        if(!(r >= 0 && r < land.length && c >= 0 && c < land[0].length)){
            return 0;//岛外return 0
        }
        if(land[r][c] != 0){
            return 0;// 不是水域或者走过的水域return 0
        }
        land[r][c] = 1;
        return 1 + pondSizes(land, r - 1, c) + pondSizes(land, r + 1, c) +
                pondSizes(land, r, c - 1) + pondSizes(land, r, c + 1) +
                pondSizes(land, r - 1, c - 1) + pondSizes(land, r - 1, c + 1) +
                pondSizes(land, r + 1, c - 1) + pondSizes(land, r + 1, c + 1);
    }

    /**
     * 79. 单词搜索
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * board =[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]
     * 给定 word = "ABCCED", 返回 true      给定 word = "SEE", 返回 true      给定 word = "ABCB", 返回 false
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && exist(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int index, int row, int cow) {
        if(index > word.length() - 1){// 全部匹配成功返回true
            return true;
        }
        if(row < 0 || row > board.length - 1 || cow < 0 || cow > board[0].length - 1){// 区域外返回false
            return false;
        }
        if(board[row][cow] == '0' || board[row][cow] != word.charAt(index)){// 已经使用过或者不匹配返回false
            return false;
        }
        char temp = board[row][cow];
        board[row][cow] = '0';
        boolean result = exist(board, word, index + 1, row - 1, cow) ||
                exist(board, word, index + 1, row + 1, cow) ||
                exist(board, word, index + 1, row , cow - 1) ||
                exist(board, word, index + 1, row, cow + 1);
        if(!result){// 全部不匹配时，恢复原来的值
            // [["C","A","A"],["A","A","A"],["B","C","D"]]"AAB"
            board[row][cow] = temp;
        }
        return result;
    }

    /**
     * 130. 被围绕的区域
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     * X X X X      运行你的函数后，矩阵变为： X X X X
     * X O O X                                X X X X
     * X X O X                                X X X X
     * X O X X                                X O X X
     * @param board
     */
    public void solve(char[][] board) {
        // 以4个边为起点分别标记相连的'O',被标记的还原，没有被标记的置为'X'
        if(board.length == 0 || board[0].length == 0){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O')
                solve(board, i, 0);
            if(board[i][col - 1] == 'O')
                solve(board, i, col - 1);
        }
        for(int j = 0; j < col; j++){
            if(board[0][j] == 'O')
                solve(board, 0, j);
            if(board[row - 1][j] == 'O')
                solve(board, row - 1, j);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void solve(char[][] board, int row, int col) {
        if(row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 ||
                board[row][col] != 'O'){// 区域外、已标记、'X'不进行标记
            return;
        }
        board[row][col] = 'A';
        solve(board, row - 1, col);
        solve(board, row + 1, col);
        solve(board, row, col - 1);
        solve(board, row, col + 1);
    }
}
