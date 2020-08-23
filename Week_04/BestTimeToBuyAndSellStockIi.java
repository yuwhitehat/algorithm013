/**
 * 题目：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 描述：设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 贪心算法
 * 只要明天的股票价格大于今天，就在今天抛出
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class BestTimeToBuyAndSellStockIi {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
