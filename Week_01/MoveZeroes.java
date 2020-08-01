class MoveZeroes{
    /**
     *
     * @param nums
     * 双指针 慢指针i,快指针j
     * 当j遇到零就跳过,遇到非零元素就和i所指的元素交换，就能把非零元素按照相对顺序移到左边
     * 时间复杂度：O(n)
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }

        }

    }
}