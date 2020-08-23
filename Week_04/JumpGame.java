/**
 * 题目：https://leetcode-cn.com/problems/jump-game/
 * 描述：给定一个非负整数数组，你最初位于数组的第一个位置。
 *      数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *      判断你是否能够到达最后一个位置。
 * 贪心算法：
 * 1. 从后往前循环，用endReachable记录最后点的下标
 * 2. 如果从位置i可以跳到的最大距离大于等于最后点的位置，就说明从位置i可以跳到最后点
 * 3. 然后将当前位置i作为最后点endReachable继续判断
 * 4. 直到最后看endReachable是否为0，如果为零说明可以到达最后一个位置
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }
}
