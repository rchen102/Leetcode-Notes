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
        int leftP = 1;
        int rightP = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = leftP;
            leftP *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * rightP;    // At this moment, res[i] -> left[i]
            rightP *= nums[i];
        }
        return res;
    }
}