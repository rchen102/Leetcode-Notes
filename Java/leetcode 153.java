/**
 * Solution: Binary Search
 * T:O(logn)  S: O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            if (nums[lo] <= nums[hi]) return nums[lo];
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else if (nums[mid] < nums[hi]) hi = mid;
        }
        return nums[lo];
    }
}

/**
 * Solution: Binary Search
 * T:O(logn)  S: O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] < nums[hi]) return nums[lo];
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] >= nums[lo]) lo = mid + 1;
            else if (nums[mid] < nums[lo]) hi = mid;
        }
        return nums[lo];
    }
}

/**
 * Solution: Traverse 
 * T: O(n) S: O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        for(int i = 1 ; i < nums.length; i++) {
            if(nums[i] < nums[i-1])
                return nums[i];
        }
        return nums[0];
    }
}