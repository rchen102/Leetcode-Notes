/**
 * Solution1: Binaray Search
 * T: O(logn) S: O(1)
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid1 = (left + right) / 2;
            int mid2 = mid1 + 1;
            if(nums[mid1] > nums[mid2])
                right = mid1;
            else
                left = mid2;
        }
        return left;
    }
}

/**
 * Solution2:
 * T: O(n) S: O(1)
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        int len = nums.length;
        if (len == 1 || nums[0] > nums[1]) return 0;
        if (nums[len-1] > nums[len-2]) return len-1;
        
        for (int i = 1; i < len-1; i++) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        }
        return -1;
    }
}

/**
 * Solution3:
 * T: O(n) S: O(1)
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) res = i;
            else {
                if (i-1 == res) return i-1; 
            }
        }
        return res;
    }
}

