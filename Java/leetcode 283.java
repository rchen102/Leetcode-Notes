/* Solution: Two Pointers
 * T: O(n) S: O(1)
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int ptr = 0;  // idx for new Array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[ptr] = nums[i];
                ptr++;
            }
        }
        while (ptr < nums.length) {
            nums[ptr] = 0;
            ptr++;
        }
    }
}