// T: O(n) S: O(1)
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i]-1);
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len || nums[i] != i+1) {
                return i+1;
            }
        }
        return len+1;
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}