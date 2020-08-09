class TwoSum{/

    /**
     * 题目描述：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 题目链接：https://leetcode-cn.com/problems/two-sum/description/
     * 一遍哈希表
     * 判断哈希表是否包含目标值的同时放入nums[i]
     * 时间复杂度: O(n)
     * 空间复杂度：O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map  = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{i,map.get(result)};
            }else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("NO SOLUTION");

    }
}