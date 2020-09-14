// Solution1: Basic dp T: O(n^2) S: O(n)
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

// Solution2: 某扑克牌算法  T: O(nlogn) S: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] tops = new int[nums.length];
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int card = nums[i];
            int find = binarySearchLeftBound(tops, piles, card);
            if (find == piles) {
                piles++;
            }
            tops[find] = card;
        }
        return piles;
    }
    
    public int binarySearchLeftBound(int[] nums, int len, int target) {
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < target) lo = mid + 1;
            else if (nums[mid] > target) hi = mid - 1;
            else hi = mid - 1; 
        }
        return lo;
    }
}