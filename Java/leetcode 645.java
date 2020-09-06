class Solution {
    // T: O(n) S: O(1)
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        
        // 使用负号来做标记
        int dup = -1;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];  // 当前遍历到的元素
            int idx = Math.abs(cur) - 1;  // 对应的 idx
            
            // 准备做标记，同时判断是否已经被标记
            if (nums[idx] < 0) {
                // 已经被标记了，所以找到了重复元素
                dup = Math.abs(cur);  // 这里注意，可能已经被别人标记了，因此使用 abs
            } else {
                // 还未被标记，标记
                nums[idx] = - nums[idx];
            }
        }
        
        // 寻找缺失元素，缺失元素对应的 idx 一定还是正数
        int miss = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                miss = i + 1;
            }
        }
        
        int[] res = new int[]{dup, miss};
        return res;
    }
}