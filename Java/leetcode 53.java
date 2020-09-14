// Solution1: 基本的 dp  T: O(n) S: O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// 基本 dp 状态压缩优化 T: O(n) S: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prev = nums[0];
        int res = prev;
        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(nums[i], prev + nums[i]);
            res = Math.max(res, prev);
        }
        return res;
    }
}

//Solution2: divide and conquer
class Solution {
    public int maxSubArray(int[] nums) {
        return findMaxSubArray(nums, 0, nums.length - 1);
    }
    
    private int findMaxSubArray(int[] nums, int low, int high) {
        if(high == low) 
            return nums[low];
        int mid = (low + high) / 2;
        int leftMax = findMaxSubArray(nums, low, mid);
        int rightMax = findMaxSubArray(nums, mid + 1, high);
        int midMax = findMaxCrossSubArray(nums, low, mid, high);
        return Math.max(midMax, Math.max(leftMax, rightMax));
    }
    
    private int findMaxCrossSubArray(int[] nums, int low, int mid, int high) {
        int sum = 0;
        int leftSum = nums[mid];
        for(int i = mid; i >= low; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        
        sum = 0;
        int rightSum = nums[mid + 1];
        for(int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}