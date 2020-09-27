// Solution1: 求和做减法 T: O(n) S: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n;
        for (int i = 0; i < n; i++) {
            // (0+...+n) - sum(nums) = missing
            sum += (i - nums[i]);
        }
        return sum;
    }
}

// Solution2: 异或 T: O(n) S: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            res ^= (i ^ nums[i]);
        }
        return res;
    }
}
