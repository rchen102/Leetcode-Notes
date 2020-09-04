// Solution1: Binary Search
// T: O(n)(worst) O(logn)(best) S: O(1)
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            if (nums[lo] < nums[hi]) return nums[lo];
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else if (nums[mid] < nums[hi]) hi = mid;
            else if (nums[mid] == nums[hi]) {
                if (hi != 0 && nums[hi-1] > nums[hi]) return nums[hi];
                hi = hi - 1;
            }
        }
        return nums[lo];
    }
}