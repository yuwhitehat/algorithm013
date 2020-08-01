class TwoSum{/

    /**
     *
     * @param nums
     * @param target
     * @return
     * 用了两遍哈希表
     * 第一遍将所有元素放到map中
     * 第二遍判断目标元素是否在map中
     * 注意目标元素的值不能为i,这是因为如果不判断，那么[3,2,4] target=6这种情况返回的就是[0,0]
     * 时间复杂度: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result) && map.get(result) != i) {
                return new int[]{i,map.get(result)};
            }
        }
        throw new IllegalArgumentException("NO SOLUTION");

    }
}