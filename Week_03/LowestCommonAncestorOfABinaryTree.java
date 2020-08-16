/**
 * 题目：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 描述：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 递归
 * 分为三种情况：
 * 1. p和q在root的两侧，说明root就是最近公共祖先
 * 2. p == root，且q在root的左子树或者右子树
 * 3. q == root，且p在root的左子树或右子树
 * 递归的退出条件：当前节点为叶子节点返回null，当p或q为root时，直接返回root
 * 递归左右子树，分别保存结果
 * 返回值：
 *  1. 当左右子树都有的时候，返回root
 *  2. 当左子树有，右子树没有就返回left
 *  3. 当右子树有，左子树没有就返回right
 *  4. 两个都没有返回null
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right != null && left != null) {
            return root;
        }else if (left != null){
            return left;
        }else if (right != null) {
            return right;
        }
        return null;

    }
}