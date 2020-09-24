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
            int position = binarySearch(card, tops, piles);
            if (position > piles-1) piles++;
            tops[position] = nums[i];
        }
        return piles;
    }
    
    // search range [0...piles-1]
    int binarySearch(int card, int[] tops, int piles) {
        int lo = 0, hi = piles - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (card > tops[mid]) lo++;
            else if (card <= tops[mid]) hi--;
        }
        return lo;
    }
}