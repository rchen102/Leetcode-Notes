//Solution1: T: O(n) S: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0, diff = 0;
        for(int i = 1; i < prices.length; i++) {
            if((diff = prices[i] - prices[i-1]) > 0)
                sum += diff;
        }
        return sum;
    }
}