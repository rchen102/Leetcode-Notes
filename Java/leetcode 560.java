// Solution: preSum + HashMap T: O(n) S: O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        // SUM[i, j] = SUM[0, j] - SUM[0, i - 1] 
        // presum -> frequency
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res += preSum.getOrDefault(sum-k, 0);
            
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}