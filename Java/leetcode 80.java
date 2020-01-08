/* Solution1: Two Pointers 
 * T: O(n) S: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < 2 || nums[i] != nums[cur-2]) {
                nums[cur] = nums[i];
                cur++;
            }
        }
        return cur;
    }
}