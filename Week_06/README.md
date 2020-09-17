# 学习笔记
## 动态规划 - DP(Dynamic Programming)
### 关键点

1. 动态规划 和 递归或者分治没有本质上的区别 （关键看有无最优的子结构）
1. **共性** ：找到重复子问题
1. **差异性**：最优子结构、中途可以淘汰次优解
<a name="zbaik"></a>
### DP的步骤

1. 找重复性（分治）
1. 定义状态数组
1. DP方程
## DP例题解析
<a name="DC1yY"></a>
### Fibonacci数列

1. 斐波那契数列如果用傻递归的话，因为有很多的重复计算，时间复杂度就是指数级的，如下
```java
int fib(int n) {
    if (n <= 1) {
       return n;
    }
    return fib(n - 1) + fib(n - 2);
}
```
![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1599185414357-a5ba8c9c-f541-4c26-99c5-737543a18161.png#align=left&display=inline&height=280&margin=%5Bobject%20Object%5D&name=image.png&originHeight=559&originWidth=1778&size=177075&status=done&style=none&width=889)<br />简化代码：简化速度以及简化表达。<br />以下是简化表达，使用三元表达式
```java
int fib(int n) {
   
    return n <= 1 ? n : fib(n - 1) + fib(n - 2);
}
```

2. 递归的时候加一个缓存（记忆化搜索），可以加一个数组来存放已经计算出来的值，下次使用的时候就不用重复计算了，直接在缓存中拿，这样时间复杂度就降到了O(n)
```java
int fib(int n , int[] memo) {
    //递归终止条件
    if (n <= 1) {
       return n;
    }
    //因为Fibonacci数列都是正数，等于0说明这个值没有被计算过
    if (memo[n] == 0){
        memo[n] = fib(n - 1) + fib(n - 2);
    }
    return memo[n];
}
```
![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1599185310812-9acbf6ba-d991-4dee-8531-f7d0d45cde98.png#align=left&display=inline&height=301&margin=%5Bobject%20Object%5D&name=image.png&originHeight=602&originWidth=1135&size=83384&status=done&style=none&width=567.5)

3. DP - 直接写一个循环，自底向上递推，不断累加。（递归的思维是自顶向下）

`F[n] = F[n - 1] + F[n - 2]` 
```java
int fib(int n , int[] a) {
    a[0] = 0;
    a[1] = 1;
    for (int i = 2;i <= n;i++) {
        a[i] = a[i - 1] + a[i - 2];
    }
   
}
```
<a name="NWtux"></a>
### 路径计数
如下图，求从左上角到右下角有多少种不同的走法。绿人只能往下和右两个方向走，橙色部分是障碍物。<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1599188119169-11299216-96f5-44aa-9fb3-5dc54456f038.png#align=left&display=inline&height=303&margin=%5Bobject%20Object%5D&name=image.png&originHeight=394&originWidth=453&size=79446&status=done&style=none&width=348)

1. 递归 - 注意要用计算机的思维，分治找重复的子问题。

解析：<br />如果想要从 `start` 走到 `end` ，绿人一步只能先走到 `B` 或者先走到 `A` ，那么就可以分解为子问题了。<br />子问题1：求从 `B` 走到 `end` 有多少种不同的走法；<br />子问题2：求从 `A` 走到 `end` 有多少种不同的走法；<br />那么子问题1 的解 + 子问题2 的解 就是从左上角到右下角不同的走法的解。<br />这就是分治的思想，如图：<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1599189061663-e5e1abdb-58f5-4f74-b927-34831fba1b59.png#align=left&display=inline&height=182&margin=%5Bobject%20Object%5D&name=image.png&originHeight=363&originWidth=1117&size=53519&status=done&style=none&width=558.5)
```java
int countPaths(boolean[][] grid, int row, int col){
    	//如果遇到障碍物返回0
        if (!validSquare(grid, row, col)) {
            return 0
        }
    	
        if (isAtEnd(grid, row, col)) {
            return 1;
        }
        return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
    }
```

2. DP - 递推

递推就是自底向上的思想，如下图，到达终点只能从上面的格子和左边的格子走一步。每一个格子的走法都是其上面的格子的走法加上左格子的走法，遇到障碍物就是0.<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1599526210742-f118d7a3-c29e-466c-8117-c1742ae2dce4.png#align=left&display=inline&height=377&margin=%5Bobject%20Object%5D&name=image.png&originHeight=754&originWidth=888&size=79829&status=done&style=none&width=444)<br />依次向上递推，我们可以得到一个递推公式，即 `opt[i , j] = opt[i, j + 1] + opt[i+ 1, j]` ， `[i, j]` 表示坐标位置。<br />完整逻辑：
```java
if opt[i, j] = "空地"
    opt[i, j] = opt[i, j + 1]  + opt[i + 1, j];
else
    opt[i, j] = 0;
```
发现最终的方法总是是 `10+17 = 27` 。<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1599191516025-9e7857ed-813e-4986-b62d-b32b865c436a.png#align=left&display=inline&height=365&margin=%5Bobject%20Object%5D&name=image.png&originHeight=730&originWidth=1020&size=95549&status=done&style=none&width=510)<br />[leetcode题解 不同路径Ⅱ](https://leetcode-cn.com/problems/unique-paths-ii/solution/jian-dan-dpbi-xu-miao-dong-by-sweetiee/)
```java
/*DP
1. 先分析出DP方程
2. 确定边界，除障碍物外边界都为1
3. 使用DP方程不断累加，这里也要注意除去障碍物
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //如果入口就有障碍，方法就为0
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0 ; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0 ; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1;j < n;j++) {
               
                if(obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
```
<a name="6Ubxu"></a>
## 总结

1. 最优子结构 `opt[n] = best_of(opt[n - 1], opt[n - 2], ...)` 
1. 存储中间状态： `opt[i]` 
1. 递推公式（状态转移方程或DP方程）

      Fib : `opt[i] = opt[n - 1] + opt[n - 2]` <br />二维路径： `opt[i,j] = opt[i + 1, j] + opt[i, j + 1]` （且判断 `a[i,j]` 是否空地）<br />
