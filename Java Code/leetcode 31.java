// Solution1: T: O(n) S: O(1)
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int idx = len - 1;
        while (idx > 0 && nums[idx] <= nums[idx-1]) idx--;
        if (idx == 0) {
            reverse(nums, 0, len - 1);
            return;
        } 
        int val = nums[idx-1];
        int idx2 = len - 1;
        while (nums[idx2] <= val) idx2--;
        swap(nums, idx-1, idx2);
        reverse(nums, idx, len-1);
    }
    
    // Reverse the array in place
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    // Swap 2 elements at idx1 and idx2
    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}