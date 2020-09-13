
// Solution1: backtrack  T: O(2^n) S: O(n)
class Solution {
    
    int result = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        backtrack(0, nums, 0, S);
        return result;
    }
    
    private void backtrack(int curSum, int[] nums, int idx, int S) {
        if (idx == nums.length) {
            if (curSum == S) result++;
            return;
        }
        // 选择 +
        backtrack(curSum + nums[idx], nums, idx+1, S);

        // 选择 -
        backtrack(curSum - nums[idx], nums, idx+1, S);
    }
}