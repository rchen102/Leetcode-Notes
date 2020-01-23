/* Solution1: Two Pointers 
 * T: O(n) S: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur < 2 || nums[cur-2] != nums[i]) {
                nums[cur] = nums[i];
                cur++;
            }
        }
        return cur;
    }
}