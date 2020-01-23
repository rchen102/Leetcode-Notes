/* Solution1: Two Pointers  
 * T: O(n) S: O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            if (nums[cur] == 2) {
                nums[cur] = nums[right];
                nums[right] = 2;
                right--;
            }
            else if (nums[cur] == 0) {
                nums[cur] = nums[left]; // we can guarantee nums[left] can not be 2
                nums[left] = 0;
                left++;
                cur++;      
            }
            else cur++;
        }
    }
}

/* Solution2: traverse and count 
 * T: O(n) S: O(1)
 */
