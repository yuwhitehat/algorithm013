class RemoveDuplicatesFromSortedArray {
    //慢指针i，快指针j,j遇到重复就跳过,不重复就赋值给nums[i]
    //时间复杂度：O(n)
    public int removeDuplicates(int[] nums) {
      int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];

            }
        }
        return i + 1;
    }
}