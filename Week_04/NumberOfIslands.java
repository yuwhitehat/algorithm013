
/**
 * 题目：https://leetcode-cn.com/problems/number-of-islands/
 * 描述：给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * dfs深度优先遍历
 * 时间复杂度：O(a*b)
 * 空间复杂度：O(a*b)
 * 思路：
 * 1. 用两层循环遍历整个网格，用count计数岛屿的数量
 * 2. 当遇到1也就是岛屿的时候，count加一，
 * 3. 然后要用dfs判断是否周围有相邻岛屿，然后将岛屿全都置为0，这样保证之后判断是否为岛屿时不会重复
 * 4. 用递归实现dfs
 *   1. 递归退出条件：坐标不超出地图范围并且当遇到水，直接退出
 *   2. 逻辑为：将岛屿置为0，然后递归岛屿的上下左右，遇到岛屿置为0
 *
 */
public class NumberOfIslands {
    private int a;
    private int b;
    public int numIslands(char[][] grid) {
        int count = 0;
        a = grid.length;
        if (a == 0) {
            return 0;
        }
        b = grid[0].length;
        for (int i = 0; i < a ; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= a || j >= b || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }



}