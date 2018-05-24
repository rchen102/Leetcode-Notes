//Solution1: dynamic programming
class Solution {
    public int maxSubArray(int[] nums) {
        int Max = nums[0];
        int sum = 0;
        for(int num : nums) {
            sum += num;
            sum = Math.max(num, sum);
            Max = Math.max(Max, sum);
        }
        return Max;
    }
}

//Solution2: divide and conquer
class Solution {
    public int maxSubArray(int[] nums) {
        return findMaxSubArray(nums, 0, nums.length - 1);
    }
    
    private int findMaxSubArray(int[] nums, int low, int high) {
        if(high == low) 
            return nums[low];
        int mid = (low + high) / 2;
        int leftMax = findMaxSubArray(nums, low, mid);
        int rightMax = findMaxSubArray(nums, mid + 1, high);
        int midMax = findMaxCrossSubArray(nums, low, mid, high);
        return Math.max(midMax, Math.max(leftMax, rightMax));
    }
    
    private int findMaxCrossSubArray(int[] nums, int low, int mid, int high) {
        int sum = 0;
        int leftSum = nums[mid];
        for(int i = mid; i >= low; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        
        sum = 0;
        int rightSum = nums[mid + 1];
        for(int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}