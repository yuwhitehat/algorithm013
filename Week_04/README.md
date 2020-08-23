# 学习笔记
## 深度优先搜索和广度优先搜索

<a name="ilOYI"></a>
### 搜索-遍历
- 每个节点要访问一次
- 每个节点仅访问一次
- 对于节点的访问顺序不同

     -深度优先 `dfs`     
     -广度优先 `bfs`<br>
     -优先级优先
## 贪心算法 Greedy

<a name="QD9pb"></a>
### 定义
一种在每一步选择中都采取当前状态下最好或最优的选择，从而希望导致结果是全局最好或最优的算法。
<a name="Rinjg"></a>
### 区别

1. 贪心：当前做局部最优判断，不能回退
1. 回溯：可以回退
1. 动态规划：会**保存**以前的最优结果并根据以前的结果对当前做出选择，可以回退
<a name="Mmmfu"></a>
### 解释

1.  贪心法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码 等，然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。
1. 一旦一个问题可以通过贪心算法来解决，那贪心法一般是解决此问题的最优解。
1. 由于其高效性 ，贪心法可以作为辅助算法
1. 也可由用来解决一些结果要求不是很精准的问题
<a name="Jikep"></a>
### 例子 
[零钱兑换](https://leetcode-cn.com/problems/coin-change/) <br />**此例子为了说明有些特定的情况才能使用贪心算法。**
```
当硬币可选集合固定：Coins = [20, 10, 5, 1]
求最少可以几个硬币拼出总数。 比如 total = 36
```
如果是像上面特定的问题，那用贪心算法求解是最优的，如下：<br />由于20，10，5，1都是可以整除最大的数20的，所以只要按顺序减掉最大的数就可以得出结果。<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1598181880534-9c65cff8-af70-47d2-8a35-0b5411bc0496.png#align=left&display=inline&height=280&margin=%5Bobject%20Object%5D&name=image.png&originHeight=560&originWidth=907&size=47562&status=done&style=none&width=453.5)<br />而如果是非整除关系的硬币呢
```
可选集合：Coins = [10, 9, 1]

求拼出总数为 18 最少需要几个硬币？
```
两个9就可以拼出18了，但是如果用贪心算法，如下：<br />要用好多硬币<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/564594/1598182204273-de8918f3-f108-4046-b4f5-f927afadccf7.png#align=left&display=inline&height=345&margin=%5Bobject%20Object%5D&name=image.png&originHeight=689&originWidth=1520&size=65945&status=done&style=none&width=760)
<a name="uwxR7"></a>
### 适用场景
问题能够分解为子问题，且子问题的最优解能够递推到最终问题的最优解。<br />这种子问题最优解称为最优子结构。<br />
<br />
## 二分查找

<a name="dz7kU"></a>
### 二分查找的前提
1. 目标函数单调递增或递减
1. 存在上下界 `bounded` 
1. 能够通过索引访问 `index accessiable` 
<a name="jWQ3g"></a>
### 代码模板
```java 
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}
```
