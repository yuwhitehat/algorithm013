/**
 * 题目：https://leetcode-cn.com/problems/minimum-path-sum/
 * 描述：给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * DP解法
 *   1. 重复子问题 - problem(i,j) = min(sub(i-1, j),sub(i, j - 1)) + a(i, j)
 *   2. 定义状态数组 - f[i][j]
 *   3. DP方程 - f[i][j] = min(f[i - 1][j], f[i][j-1]) + a[i][j]
 *       边界：
 *      f[i][0] = f[i - 1][0] + a[i][0];
 *      f[0][j] = f[0][j - 1] + a[0][j];
 *  时间复杂度：O(mn)
 *  空间复杂度：O(mn)
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid == null || m == 0 || n == 0) {
            return 0;
        }
        int[][] opt = new int[m][n];
        opt[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            opt[i][0] = opt[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            opt[0][i] = opt[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                opt[i][j] = Math.min(opt[i - 1][j] , opt[i][j - 1]) + grid[i][j];
            }

        }
        return opt[m - 1][n -1];
    }
}