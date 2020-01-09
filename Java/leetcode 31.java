/* Solution: 
 * T: O(n) S: O(1)
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int idx1 = findFirstDecreaseFromEnd(nums);
        if (idx1 != -1) {
            int idx2 = findFirstBiggerThan(nums, nums[idx1]);
            swap(nums, idx1, idx2);
        }
        reverse(nums, idx1+1, nums.length - 1);
    }
    
    private int findFirstDecreaseFromEnd(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) return i-1;
        }
        return -1;
    }
    
    private int findFirstBiggerThan(int[] nums, int target) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > target) return i;
        }
        return -1;
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}