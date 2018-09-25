// Solution1: binary search and dp T: O(nlogn) S: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for(int num : nums) {
            int low = 0, high = size;
            while(low != high) {
                int mid = (low + high) / 2;
                if(tails[mid] < num)
                    low = mid + 1;
                else
                    high = mid;
            }
            tails[low] = num;
            if(low == size) ++size;
        }
        return size;
    }
}

//Solution more easy understand: T: O(n^2) S: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}