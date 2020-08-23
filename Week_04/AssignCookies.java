/**
 * 题目：https://leetcode-cn.com/problems/assign-cookies/
 * 描述：分发饼干
 * 贪心算法
 * 时间复杂度：sort排序O(nlogn),循环O(n),取最大O(nlogn)
 * 空间复杂度：O(1)
 * 思路：
 * 1. 对两个数组排序
 * 2. 对每一个孩子的胃口值都刚好找到适合其的最小的饼干尺寸
 * 3. 如果找到适合的尺寸，就给孩子，如果没有就看下一个饼干是否适合
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }
        return child;
    }
}