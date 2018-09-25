//Solution1: divide and conquer T: O(nlogn) S: O(logn)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) 
            return 0;
        int res = subMax(prices, 0, prices.length - 1);
        return res;
    }
    
    public int subMax(int[] prices, int start, int end) {
        if(start == end) return 0;
        
        int mid = (start + end)/2;
        int tmp = getMax(prices, mid + 1, end) - getMin(prices, start, mid);
        if(tmp < 0) tmp = 0;
        
        int tmp2 = Math.max(subMax(prices, start, mid), subMax(prices, mid + 1, end));
        return Math.max(tmp, tmp2);
    }
    
    //Get max in the array prices from index start to end
    public int getMax(int[] prices, int start, int end) {
        int max = prices[start];
        for(int i = start; i <= end; i++) {
            if(prices[i] > max)
                max = prices[i];
        }
        return max;
    }
    
    //Get min in the array prices from index start to end
    public int getMin(int[] prices, int start, int end) {
        int min = prices[start];
        for(int i = start; i <= end; i++) {
            if(prices[i] < min)
                min = prices[i];
        }
        return min;
    }    
    
}


//Solution2: Kadane's Algorithm (dynamic programming) T: O(n) S: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSofar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSofar= Math.max(maxCur, maxSofar);
        }
        return maxSofar;
    }
}