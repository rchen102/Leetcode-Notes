// Sliding Window T: O(2n)  S: O(1)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        return maxK(nums, k) - maxK(nums, k-1);
    }
    
    private int maxK(int[] arr, int k) {   
        int res = 0;
        // sliding window
        int left = 0, right = 0;
        while (right < arr.length) {
            int come = arr[right];
            right++;
            // update
            if (come % 2 == 1) k--;
            
            // shrink
            while (k < 0) {
                int leave = arr[left];
                left++;
                if (leave % 2 == 1) k++;
            }
            res += right - left;
        }
        return res;
    }
}