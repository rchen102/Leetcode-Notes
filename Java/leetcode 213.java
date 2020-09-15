// Solution: 基本 dp + 状态压缩  T: O(n) S: O(1)
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length-1));
        
    }
    
    public int robRange(int[] nums, int lo, int hi) {
        int prev = 0;
        int cur = nums[hi];
        for (int i = hi-1; i >= lo; i--) {
            int tmp = cur;
            cur = Math.max(cur, nums[i] + prev);
            prev = tmp;
        }
        return cur;
    }
}