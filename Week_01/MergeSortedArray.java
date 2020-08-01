class MergeSortedArray{
    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * 三个指针 p,p1,p2
     * p从nums1的最后开始向前走
     * p1从nums1的m-1的地方开始往前走
     * p2从nums2的n-1的地方开始走
     * 比较p1和p2指向的元素的大小，谁大谁先放到p所指的位置
     * 最后如果nums2里有剩余，说明剩余的元素都比nums[0]小，那么就直接拷贝到nums1里
     * 时间复杂度： O(n)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n-1;
        int p1 = m-1;
        int p2 = n-1;
        while (p1>=0 && p2>=0) {
            nums1[p--] = nums1[p1]>nums2[p2]?nums1[p1--]:nums2[p2--];

        }
        System.arraycopy(nums2,0,nums1,0,p2+1);

    }
}