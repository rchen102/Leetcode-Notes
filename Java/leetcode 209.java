/* Solution1: Sliding Window
 * T: O(n) S: O(1)
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // helper vars
        int sum = 0, len = nums.length + 1;
        
        // sliding window
        int left = 0, right = 0;
        boolean isNeedShrink = false;
        while (right < nums.length) {
            int n = nums[right];
            right++;
            
            sum += n;
            if (sum >= s) isNeedShrink = true;
            
            while (isNeedShrink) {
                len = Math.min(len, right - left);
                
                int toRemove = nums[left];
                left++;
                
                sum -= toRemove;
                if (sum < s) isNeedShrink = false;
            }
        }
        return len > nums.length ? 0 : len;
    }
}

//Solution2: Binary Search T: O(nlogn) S: O(n)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] sum = new int[len+1];
        for(int i = 1; i <= len; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= len; i++) {
            int end = binarySearch(i+1, len, sum[i] + s, sum);
            if(end > len) break;
            min = Math.min(min, end - i);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    private int binarySearch(int lo, int hi, int key, int[] arr) {
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] >= key) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}