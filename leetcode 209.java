//Solution1: Two pointers T: O(n) S: O(1)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        
        while(j < nums.length) {
            sum += nums[j++];
            while(sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
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