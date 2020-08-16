public class Combinations {
    /**
     * 题目：https://leetcode-cn.com/problems/combinations/
     * 描述：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * 思想：回溯
     * k限制了数的高度，n限制了书的宽度
     * 结束条件：组合完成，添加到集合中
     * 逻辑：从1到n遍历，每次取i放到集合中，通过回溯得到组合
     * @param n
     * @param k
     * @return
     */
    private List<List<Integer>> res = new ArrayList<>();

    private void findCombinations(int n, int k, int begin, Stack<Integer> pre) {
        if (pre.size() == k) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = begin; i <= n; i++) {
            pre.add(i);
            findCombinations(n, k, i + 1, pre);
            pre.pop();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        findCombinations(n, k, 1, new Stack<>());
        return res;
    }

}