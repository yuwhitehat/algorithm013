public class NAryTreePreorderTraversal{
    /**
     * 题目描述：给定一个 N 叉树，返回其节点值的前序遍历。
     * 题目链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
     * 方法：递归
     * 递归退出条件：当根节点为空
     * 返回值：返回已经遍历完的节点的集合
     * 当前层的逻辑：把根节点的值放进集合中，再把孩子的值放入集合中
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return res;
    }
}
