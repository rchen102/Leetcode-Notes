class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> miss = new ArrayList<>();
        if (nums == null || nums.length == 0) return miss;
        
        // 通过映射，出现过的元素，对应 idx 上的值，标记为负数
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int idx = Math.abs(cur) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        
        // 遍历，寻找没有被标记的元素，即对应 idx 上值为正数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                miss.add(i + 1);
            }
        }
        return miss;
    }
}