/* Solution1: Two Pointers  
 * T: O(n) S: O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                i--; // re-process the nums[i], since it can be zero after swap
            } 
            i++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/* Solution2: traverse and count 
 * T: O(n) S: O(1)
 */
