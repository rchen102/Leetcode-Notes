/* Solution: 
 * T: O(n) S: O(1)
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int idx1 = findFirstDecreaseFromEnd(nums);
        if (idx1 == -1) {
            reverse(nums, 0, nums.length-1);
        }
        else {
            int idx2 = findFirstBiggerFromEnd(nums, idx1);
            swap(nums, idx1, idx2);
            reverse(nums, idx1+1, nums.length-1);
        }
    }
    
    /*
     * From end of array, trace back
     * find first element i that nums[i] < nums[i+1]
     * T: O(n) S: O(1)
     */
    private int findFirstDecreaseFromEnd(int[] nums) {
        int pointer = nums.length - 1;
        while (pointer > 0) {
            if (nums[pointer - 1] < nums[pointer]) break;
            pointer--;
        }
        return pointer-1;
    }
    
    /*
     * From end of array, trace back
     * T: O(n) S: O(1)
     */
    private int findFirstBiggerFromEnd(int[] nums, int idx1) {
        int target = nums[idx1];
        for (int i = nums.length - 1; i > idx1; i--) {
            if (nums[i] > target) return i;
        }
        return -1; // Not found, should be impossible 
    }
    
    /*
     * reverse array from start to end
     * T: O(n) S: O(1)
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}