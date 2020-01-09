/* Solution1:
 * T: O(n) S: O(n)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftP = 1;
        int rightP = 1;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            left[i] = leftP;
            leftP *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = rightP;
            rightP *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}

/* Solution2: better one
 * T: O(n) S: O(1)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}