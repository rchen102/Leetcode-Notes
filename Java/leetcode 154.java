// Solution1: Binary Search
// T: O(n)(worst) O(logn)(best) S: O(1)
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] < nums[hi]) return nums[lo];
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < nums[hi]) hi = mid;
            else if (nums[mid] > nums[hi]) lo = mid + 1;
            else {
                // nums[mid] == nums[hi]
                if (nums[hi-1] > nums[hi]) return nums[hi];
                hi--;
            }
        }
        return nums[lo];
    }
}

// Solution2: traverse T: O(n) S: O(1)
class Solution {
    public int findMin(int[] nums) {
        for(int i = 1 ; i < nums.length; i++) {
            if(nums[i] < nums[i-1])
                return nums[i];
        }
        return nums[0];
    }
}


// Solution3: remove the duplicate elements T: O(n) S: O(n)
class Solution {
    public int findMin(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] filtered = new int[nums.length];
        int n = 0;
        
        for(int num : nums) {
            if(set.add(num)) {
                filtered[n++] = num;
            }      
        }
        return find(filtered, n);
    }

    private int find(int[] nums, int n) {
        int left = 0;
        int right = n - 1;
        while(left < right) {
            int mid = (left + right)/2;
            if(nums[mid] < nums[right])
                right = mid;
            else
                left = mid + 1;
        }
        return nums[left];
    }    
}