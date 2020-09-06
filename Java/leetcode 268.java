//Solution1: Bit manipulation  T: O(n) S: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            res ^= (i ^ nums[i]);
        }
        return res;
    }
}

//Solution2: iterative T: O(n) S: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (i - nums[i]);
        }
        // (1+...+n) - sum(nums) = missing
        return sum+n;
    }
}