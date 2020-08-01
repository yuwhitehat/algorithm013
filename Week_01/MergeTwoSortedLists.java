class MergeTwoSortedLists{
    /**
     *
     * @param l1
     * @param l2
     * @return
     * 思想：递归
     * 1.递归退出条件：l1为空或l2为空
     * 2.本层逻辑：l1头节点和l2头节点的值比较大小，小的连接已经合并完的链表的头节点
     * 3.返回值：返回已经合并好的链表的头节点
     * 时间复杂度：O(m+n) m是l1的节点个数，n是l2的节点个数
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }
}