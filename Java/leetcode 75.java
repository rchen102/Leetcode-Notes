/* Solution1: Two Pointers  
 * T: O(n) S: O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                nums[cur] = nums[left];
                nums[left] = 0;
                left++;
                cur++;
                continue;
            }
            if (nums[cur] == 2) {
                nums[cur] = nums[right];
                nums[right] = 2;
                right--;
                continue;
            }
            cur++;
        }
    }
}

/* Solution2: traverse and count 
 * T: O(n) S: O(1)
 */
